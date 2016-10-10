package com.tiad.SchoolDiary.tools;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
import org.hibernate.tool.schema.TargetType;

public class SchemaGenerator {
	/**
	 * Method that actually creates the file.
	 * 
	 * @throws Exception
	 */
	public void generate(String file, String packageName, Configuration cfg) throws Exception {
		ServiceRegistry serviceRegistry = buildCfg(cfg);
		MetadataSources metadata = new MetadataSources(serviceRegistry);

		for (Class<?> clazz : getClasses(packageName)) {
			metadata.addAnnotatedClass(clazz);
		}

		SchemaExport schemaExport = new SchemaExport();

		schemaExport.setDelimiter(";");
		schemaExport.setOutputFile(file);
		schemaExport.execute(EnumSet.of(TargetType.SCRIPT), Action.BOTH,
				metadata.buildMetadata());
		((StandardServiceRegistryImpl) serviceRegistry).destroy();
	}

	private ServiceRegistry buildCfg(Configuration cfg) {
		return (ServiceRegistry) cfg.getStandardServiceRegistryBuilder()
				.build();
	}

	/**
	 * Utility method used to fetch Class list based on a package name.
	 * 
	 * @param packageName
	 *            (should be the package containing your annotated beans.
	 */
	private List<Class<?>> getClasses(String packageName) throws Exception {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		File directory = null;

		ClassLoader cld = Thread.currentThread().getContextClassLoader();
		if (cld == null) {
			return classes;
		}
		String path = packageName.replace('.', '/');
		URL resource = cld.getResource(path);
		if (resource == null) {
			return classes;
		}
		directory = new File(resource.getFile());

		if (directory.exists()) {
			String[] files = directory.list();
			for (int i = 0; i < files.length; i++) {
				if (files[i].endsWith(".class")) {
					// removes the .class extension
					classes.add(Class.forName(packageName + '.'
							+ files[i].substring(0, files[i].length() - 6)));
				}
			}
		}

		return classes;
	}
}
