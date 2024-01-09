package es.ieslavereda;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Board {


    private Cell[][] cells;

    //Constructores
    public Board(){
        cells = new Cell[8][8];
        char letter = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j<cells[0].length; j++) {
                cells[i][j] = new Cell(this, new Coordinate((char)('A'+j),i+1));
            }
        }
    }

    public boolean contains(Coordinate c) {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cells[i][j].getCoordinate().equals(c)){
                    return true;
                }
            }
        }
        return false;
    }

    public Cell getCellAt(Coordinate c) {
        if (contains(c)){
            return new Cell(this, c);
        }
        return null;
    }

    //Override
    @Override
    public String toString(){
        String aux = colorize("    A  B  C  D  E  F  G  H    \n", Attribute.TEXT_COLOR(0,0,0), Attribute.BACK_COLOR(255,255,255));
        for (int i = 0; i<cells.length; i++) {
            aux += colorize(" " + (i+1) + " ",Attribute.TEXT_COLOR(0,0,0), Attribute.BACK_COLOR(255,255,255));
            for (int j = 0; j < this.cells[0].length; j++) {
                aux += cells[i][j] + "";
            }
            aux += colorize(" " + (i+1) + " \n", Attribute.TEXT_COLOR(0,0,0), Attribute.BACK_COLOR(255,255,255));
        }
        aux += colorize("    A  B  C  D  E  F  G  H    ", Attribute.TEXT_COLOR(0,0,0), Attribute.BACK_COLOR(255,255,255));
        return aux;
    }

}


