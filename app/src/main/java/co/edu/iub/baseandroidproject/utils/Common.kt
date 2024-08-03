package co.edu.iub.baseandroidproject.utils

import android.content.Context
import android.widget.Toast

/**
 * La clase Common. No tiene modificadores de acceso, lo que significa que es accesible desde
 * cualquier lugar dentro del mismo paquete.
 */
class Common {

    /**
     * companion object: Es un objeto que es común a todas las instancias de una clase.
     * En este caso, se utiliza para contener el método showToast, que es un método estático
     */
    companion object {

        fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
            Toast.makeText(context, message, duration).show()
        }

    }

}
