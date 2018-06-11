package com.activites;
/**
 * Implémentation de la Classe Grille, GrilleImp.java.
 * @author FRIEDEN
 *
 */
public class GrilleImpl implements Grille {
    /**
     * param grille la grille du jeu.
     */
    private final char[][]grille;

    /**
     * Initialisation de la grille de jeu.
     * @param dimension taille de la grille
     */
    public GrilleImpl(final int dimension) {
        grille = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grille[i][j] = EMPTY;
            }
        }
    }
    @Override
    public final int getDimension() {
        return grille.length;
    }

    @Override
    public final void setValue(final int x, final int y, final char value)
        throws IllegalArgumentException {

        if (valeurHorsBornes(x, y)) {
            throw new IllegalArgumentException("L'une des valeurs est"
                    + " hors bornes");
        }

        if (!possible(x, y, value)) {
            throw new IllegalArgumentException("Valeur interdite"
                    + " au vue des autres valeurs de la grille");
        }

        if (!caractereAutorise(value)) {
            throw new IllegalArgumentException("Caractère non autorisé");
        }

        grille[x][y] = value;
    }
    /**
     * Vérifie si le caractère à mettre dans la case est autorisée.
     * @param value valeur à mettre dans la case
     * @return true si le caractère est autorisé
     */
    private boolean caractereAutorise(final char value) {
        for (int i = 0; i < grille.length; i++) {
            if (value == POSSIBLE[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vérifie si le caractère à entrer est dans les bornes de la grille.
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return true si la valeur est hors bornes.
     */
    private boolean valeurHorsBornes(final int x, final int y) {
        if ((x < 0 || x >= grille.length)
                || (y < 0 || y >= grille.length)) {
            return true;
        }
        return false;
    }

    @Override
    public final char getValue(final int x, final int y)
            throws IllegalArgumentException {

        valeurHorsBornes(x, y);
        return grille[x][y];
    }

    @Override
    public final boolean complete() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille.length; j++) {
                if (grille[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public final boolean possible(final int x, final int y, final char value)
            throws IllegalArgumentException {

        //Vérification de la présence de la valeur sur la ligne
        for (int colonne = 0; colonne < grille.length; colonne++) {
            if (grille[x][colonne] == value) {
                return false;
            }
        }

        //Vérification de la présence de la valeur sur la colonne
        for (int ligne = 0; ligne < grille.length; ligne++) {
            if (grille[ligne][y] == value) {
                return false;
            }
        }

        return true;
    }

}
