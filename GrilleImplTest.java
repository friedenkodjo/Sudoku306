package com.tests;
import com.activites.Grille;
import com.activites.GrilleImpl;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Classe de test GrilleImpl, GrillImplTest.java.
 * @author FRIEDEN
 *
 */

class GrilleImplTest {

    /**
     * Test de la grille GrilleImpl.
     */
    @Test
    void testGrilleImpl() {
        // Vérifier si une position de la grille est vide au départ.
        final int dimension = 9;
        final int x = 2;
        final int y = 3;
        GrilleImpl grille = new GrilleImpl(dimension);
        Assert.assertEquals(Grille.EMPTY, grille.getValue(x, y));
    }
    /**
     * Test methode getDimension.
     */
    @Test
    void testGetDimension() {
        final int dimension = 9;
        GrilleImpl grille = new GrilleImpl(dimension);
        Assert.assertEquals(dimension, grille.getDimension());
    }
    /**
     * Tests methode setValue.
     */
    @Test
    void testSetValue() {

        final int dimension = 9;
        final int xHorsBornes = 9;
        char valeurNonAutorisee = 'K';

        final int x = 0;
        final int y = 8;
        char value = '1';


        GrilleImpl grille = new GrilleImpl(dimension);

        // Test 1: Insertion d'une valeur
        // possible à une position dans les bornes
        grille.setValue(x, y, value);
        Assert.assertEquals(value, grille.getValue(x, y));

        // Test 2: Tentative d'insertion d'une valeur possible
        // à une position hors bornes.
        try {
            grille.setValue(xHorsBornes, y, value);
            fail("Exception valeur hors bornes non levée");
        } catch (IllegalArgumentException e) {

        }
        // Test 3: Tentative d'insertion d'une valeur
        // non autorisée à une position dans les bornes.
        try {
            grille.setValue(x, y, valeurNonAutorisee);
            fail("Exception valeur hors bornes non levée");
        } catch (IllegalArgumentException e) {

        }

        // Test 4: Tentative d'insertion d'une valeur
        // non autorisée à une position hors bornes.
        try {
            grille.setValue(xHorsBornes, y, valeurNonAutorisee);
            fail("Exception valeur non autorisée non levée");
        } catch (IllegalArgumentException e) {

        }

    }
    /**
     * Test méthode getValue.
     */
    @Test
    void testGetValue() {
        final int dimension = 9;
        final int x = 3, y = 4;
        char value = '1';
        GrilleImpl grille = new GrilleImpl(dimension);
        grille.setValue(x, y, value);
        Assert.assertEquals(value, grille.getValue(x, y));
    }
    /**
     * Test methode complete.
     */
    @Test
    void testComplete() {

        final int dimension = 9;
        GrilleImpl grille = new GrilleImpl(dimension);

        //Test 1: Remplissage du tableau avec des nombres aléatoires
        int aleatoire = (int) (Math.random() * dimension);

        try {
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    grille.setValue(i, j, Grille.POSSIBLE[aleatoire]);
                }
            }
        } catch (Exception e) {
        }
        // Vérifier que la grille n'est pas complete
        Assert.assertFalse(grille.complete());
    }
    /**
     * Test methode possible.
     */
    @Test
    void testPossible() {
        final int dimension = 9;
        final int x = 8, y = 8;
        char value = '7';

        GrilleImpl grille = new GrilleImpl(dimension);
        // Test 1: Vérification de la possibilité d'insérer une valeur
        // par rapport à ce que la grille contient déjà

        //Insertion d'une valeur à la position (x,y)
        grille.setValue(x, y, value);

        //On ne devrait plus pouvoir insérer une valeur à la même position
        Assert.assertFalse(grille.possible(x, y, value));

    }
}
