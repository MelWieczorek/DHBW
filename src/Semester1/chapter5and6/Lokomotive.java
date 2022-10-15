package Semester1.chapter5and6;

public class Lokomotive {
   private int id;
   private int ps;
   Gueterzug gueterzug;

   public Lokomotive(int id, int ps) {
      this.setId(id);
      this.setPs(ps);
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getPs() {
      return ps;
   }

   public void setPs(int ps) {
      this.ps = ps;
   }

   public Gueterzug getGueterzug() {
      return gueterzug;
   }

   public void setGueterzug(Gueterzug gueterzug) {
      this.gueterzug = gueterzug;
   }
}
