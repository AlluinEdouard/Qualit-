import java.util.ArrayList;

class Davalier extends Piece {
    
    public Davalier() {
        super('B', new Position());
    }

    public Davalier(char couleur, Position position) {
        super(couleur, position);
    }

    @Override
    public String getType() {
        return "davalier";
    }

    @Override
    public ArrayList<Position> getDeplacementPossible(Plateau pl) {
        ArrayList<Position> deplacements = new ArrayList<>();

        // Utiliser les déplacements de la Dame
        Dame dame = new Dame(this.getCouleur(), this.getPosition());
        deplacements.addAll(dame.getDeplacementPossible(pl));

        // Utiliser les déplacements du Cavalier
        Cavalier cavalier = new Cavalier(this.getCouleur(), this.getPosition());
        deplacements.addAll(cavalier.getDeplacementPossible(pl));

        return deplacements;
    }
}

