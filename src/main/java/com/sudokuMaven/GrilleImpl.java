package com.sudokuMaven;
/**
 * Impl�mentation de la Classe Grille, GrilleImp.java.
 * @author Frieden, Loic, Ludovic.
 *
 */
public class GrilleImpl implements Grille {
    /**
     * @param grille le tableau repr�sentant la grille du jeu.
     */
    private final char[][]grille;

    
    
    /**
     * Initialisation de la grille de jeu.
     * 
     * @param dimension la taille de la grille.
     */
    public GrilleImpl(final int dimension) {
        
        /* Cr�ation de la grille avec la taille entr�e en
         * param�tre: 9 ou 16.
         */
        grille = new char[dimension][dimension];
        
        //Remplissage initial des cases de la grille avec la valeur EMPTY.
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grille[i][j] = EMPTY;
            }
        }
    }

    
    
    public final int getDimension() {
        return grille.length;
    }
    
    

    /**
     * Ecriture de la methode setValue.
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
     */
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
            throw new IllegalArgumentException("Caract�re non autoris�");
        }

        grille[x][y] = value;
    }
    
    
    
    /**
     * V�rifie si le caract�re � mettre dans la case est autoris�e.
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
     * @param value valeur � mettre dans la case
     * @return true si le caract�re est autoris�
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
     * V�rifie si le caract�re � entrer est dans les bornes de la grille.
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
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
    
    
    
    /**
     * Ecriture de la methode getValue.
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
     */
    public final char getValue(final int x, final int y)
            throws IllegalArgumentException {

        valeurHorsBornes(x, y);
        return grille[x][y];
    }
    
    
    
    public final boolean complete() {
        //Non encore impl�ment�
        return true;
    }
    
    
    
    public final boolean possible(final int x, final int y, final char value)
            throws IllegalArgumentException {
        //Non encore impl�ment�
        return true;
    }

}
