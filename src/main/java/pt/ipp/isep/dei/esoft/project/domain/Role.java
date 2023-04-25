package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class Role {
    private final String name;

    public Role(String name){ this.name = name; }

    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (!(o instanceof Role)){
            return false;
        }
        Role that = (Role) o;
        return name.equalsIgnoreCase(that.name);
    }

    public String getName(){ return name; }

    public int hashCode(){ return Objects.hashCode(name); }

    public Role clone() { return new Role(this.name); }
}
