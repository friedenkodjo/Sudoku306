package com.sudokuMaven;
import static org.junit.Assert.fail;
import org.junit.Assert;

/**
 * Classe de test GrilleImpl, GrillImplTest.java.
 * 
 * @author Frieden, Loic, Ludovic.
 *
 */

class GrilleImplTest {

    /**
     * Tests methode setValue.
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
     */
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
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
     */
    void testGetValue() {
        final int dimension = 9;
        final int x = 3, y = 4;
        char value = '1';
        GrilleImpl grille = new GrilleImpl(dimension);
        grille.setValue(x, y, value);
        Assert.assertEquals(value, grille.getValue(x, y));
    }

}
