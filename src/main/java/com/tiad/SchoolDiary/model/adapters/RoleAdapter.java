package com.tiad.SchoolDiary.model.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.tiad.SchoolDiary.model.Role;

public class RoleAdapter extends XmlAdapter<String, Role> {

    @Override
    public Role unmarshal(String roleString) throws Exception {
        return Role.of(roleString);
    }

    @Override
    public String marshal(Role role) throws Exception {
        return role.getValue();
    }
}
