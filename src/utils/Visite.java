package utils;

public class Visite implements Comparable<Visite> {
    private String nomEtudiant;
    private String date;
    private int note;

    /**
     * @param nomEtudiant String
     * @param date String
     * @param note int
     */
    public Visite(String nomEtudiant, String date, int note) {
        this.nomEtudiant = nomEtudiant;
        this.date = date;
        this.note = note;
    }

    /**
     * Construct with empty strings
     */
    public Visite() {
        this.nomEtudiant = "";
        this.date = "";
    }

    /**
     * @return String
     */
    public String getNomEtudiant() {
        return nomEtudiant;
    }

    /**
     * @param nomEtudiant String
     * @return Visite
     */
    public Visite setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
        return this;
    }

    /**
     * @return int
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date String
     * @return Visite
     */
    public Visite setDate(String date) {
        this.date = date;
        return this;
    }

    /**
     * @return int
     */
    public int getNote() {
        return note;
    }

    /**
     * @param note int
     * @return Visite
     */
    public Visite setNote(int note) {
        this.note = note;
        return this;
    }

    @Override
    public String toString() {
        return this.getNomEtudiant()+" - "+this.getDate();
    }

    @Override
    public int compareTo(Visite visite) {
        return visite.nomEtudiant.equals(this.nomEtudiant) ? 1 : 0;
    }
}
