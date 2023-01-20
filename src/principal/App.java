/**
 * Autor: Nancy Obed Martínez Miguel
 * Fecha de creación: 04 de diciembre de 2022
 * Fecha de actualización: 05 de diciembre de 2022
 * Descripción: desde aquí se instanciará a la clase logueo para iniciar el
 *              programa.
 */
package principal;

import javax.swing.SwingUtilities;
import view.PlantillaLogueo;

public class App {

    public static void main(String[] args) {
        Runnable runApplication = new Runnable() {
            @Override
            public void run() {
                PlantillaLogueo logueo = new PlantillaLogueo();
                logueo.getClass();
            }
        };
        SwingUtilities.invokeLater(runApplication);

    }

}
