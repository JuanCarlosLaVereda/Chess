package es.ieslavereda;

import com.diogonunes.jcolor.Attribute;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Cell {

    private Piece piece;
    private Board board;
    private Coordinate coordinate;
    private Color originalColor;
    private Color color;

    public Cell(Board board, Coordinate coordinate) {
        this.board = board;
        this.coordinate = coordinate;
        this.piece = null;

        if ((coordinate.getNumber() + coordinate.getLetter()) % 2 == 1) {
            this.originalColor = Color.BLACK;
        } else {
            this.originalColor = Color.WHITE;
        }
        this.color = originalColor;

    }

    public boolean isEmpty(){
        return piece==null;
    }

    public Piece getPiece() {
        return piece;
    }

    public Board getBoard() {
        return board;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString(){
        if (isEmpty()){
            return colorize("   ",this.getColor().getAttribute());
        }
        return colorize(" ", getColor().getAttribute()) + piece + colorize(" ", getColor().getAttribute());
    }

    public enum Color {
        WHITE(Attribute.BACK_COLOR(180,180,180)),
        BLACK(Attribute.BACK_COLOR(100,100,100)),
        HIGHLIGHT_KILL_WHITE(Attribute.BACK_COLOR(180,0,0)),
        HIGHLIGHT_KILL_BLACK(Attribute.BACK_COLOR(130,0,0)),
        HIGHLIGHT_WHITE(Attribute.BACK_COLOR(180,180,0)),
        HIGHLIGHT_BLACK(Attribute.BACK_COLOR(130,130,0));

        private Attribute color;

        Color(Attribute color) {
            this.color = color;
        }

        public Attribute getAttribute() {
            return color;
        }
    }
}