package com.tiad.SchoolDiary.tools;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class SchemaGenerator {
	private Configuration cfg;

	public SchemaGenerator(Configuration c, String packageName) throws Exception {
		cfg = c;
		
		for (Class<?> clazz : getClasses(packageName)) {
			cfg.addAnnotatedClass(clazz);
		}
	}

	/**
	 * Method that actually creates the file.
	 * 
	 * @param dbDialect
	 *            to use
	 */
	public void generate(String file) {
		SchemaExport export = new SchemaExport(cfg);
		export.setDelimiter(";");
		
		export.setOutputFile(file);
		export.execute(true, true, false, false);
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
		try {
			ClassLoader cld = Thread.currentThread().getContextClassLoader();
			if (cld == null) {
				throw new ClassNotFoundException("Can't get class loader.");
			}
			String path = packageName.replace('.', '/');
			URL resource = cld.getResource(path);
			if (resource == null) {
				throw new ClassNotFoundException("No resource for " + path);
			}
			directory = new File(resource.getFile());
		} catch (NullPointerException x) {
			throw new ClassNotFoundException(packageName + " (" + directory
					+ ") does not appear to be a valid package");
		}
		if (directory.exists()) {
			String[] files = directory.list();
			for (int i = 0; i < files.length; i++) {
				if (files[i].endsWith(".class")) {
					// removes the .class extension
					classes.add(Class.forName(packageName + '.'
							+ files[i].substring(0, files[i].length() - 6)));
				}
			}
		} else {
			throw new ClassNotFoundException(packageName
					+ " is not a valid package (" + directory.getPath() + ")");
		}

		return classes;
	}
}
