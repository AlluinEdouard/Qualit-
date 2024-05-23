import java.util.ArrayList;

class Favalier extends Piece {
    
    public Favalier(){
        super('B', new Position());
    }

    public Favalier(char couleur, Position position){
        super(couleur, position);
    }

    @Override
    public String getType(){
        return "favalier";
    }

    @Override
    public ArrayList<Position> getDeplacementPossible(Plateau pl) {
        ArrayList<Position> liste = new ArrayList<Position>();
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();

        // Déplacements de la tour
        for(int i = positionDepartX + 1; i < 8; i++) {
            Piece pi = pl.getCase(i, positionDepartY);
            if(pi == null)
                liste.add(new Position(i, positionDepartY));
            else {
                if(pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(i, positionDepartY));
                break;
            }
        }
        for(int i = positionDepartX - 1; i >= 0; i--) {
            Piece pi = pl.getCase(i, positionDepartY);
            if(pi == null)
                liste.add(new Position(i, positionDepartY));
            else {
                if(pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(i, positionDepartY));
                break;
            }
        }
        for(int j = positionDepartY + 1; j < 8; j++) {
            Piece pi = pl.getCase(positionDepartX, j);
            if(pi == null)
                liste.add(new Position(positionDepartX, j));
            else {
                if(pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(positionDepartX, j));
                break;
            }
        }
        for(int j = positionDepartY - 1; j >= 0; j--) {
            Piece pi = pl.getCase(positionDepartX, j);
            if(pi == null)
                liste.add(new Position(positionDepartX, j));
            else {
                if(pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(positionDepartX, j));
                break;
            }
        }

        // Déplacements du cavalier
        int[][] deplacementsCavalier = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}};
        for(int[] deplacement : deplacementsCavalier) {
            int newX = positionDepartX + deplacement[0];
            int newY = positionDepartY + deplacement[1];
            if(newX >= 0 && newX < 8 && newY >= 0 && newY < 8) {
                Piece pi = pl.getCase(newX, newY);
                if(pi == null || pi.getCouleur() != this.getCouleur())
                    liste.add(new Position(newX, newY));
            }
        }

        return liste;
    }
}
