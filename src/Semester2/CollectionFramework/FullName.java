package Semester2.CollectionFramework;

public class FullName implements Comparable<FullName> {
    private String name;
    private  String family_name;
    public FullName(String name, String family_name){
        this.name = name;
        this.family_name = family_name;
    }
    public String getName(){
        return name;
    }
    public String getFamily_name(){
        return family_name;
    }
    @Override
    public String toString(){
        return family_name + "," + name;
    }

    @Override
    // --> Muss selbst implementiert sein, da "natürliche" Ordnung bei eigenen Objekten nicht allgemein bekannt sind --> Ordnung selbst eingebaut
    public int compareTo(FullName o) {
        if(!this.family_name.equals(o.family_name)){
            return this.family_name.compareTo(o.family_name);
        }
        return this.name.compareTo(o.name);
    }
    @Override
    //--> Bei equals sollte das gleiche Ergebnis wie bei compare To rauskommen --> Deshalb überschreiben
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }
        FullName nameToCompare = (FullName)o;
        if (!this.family_name.equals(nameToCompare.family_name)){
            return false;
        }
        if (!this.name.equals(nameToCompare.name)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return family_name.hashCode() + name.hashCode(); //Inhaltlich gleiche Strings geben auch gleichen HashCode zurück --> durch Erstellung des HashCodes auf Basis der einzelnen Strings --> unterschiedliche OBjekte mit gleichem Inhalt haben jetzt auch den gleichen Hash-Code
    }
}
