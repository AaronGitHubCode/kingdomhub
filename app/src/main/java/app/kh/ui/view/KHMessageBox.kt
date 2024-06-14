package app.kh.ui.view

import app.kh.R

import android.content.Context
import android.graphics.Canvas

import android.util.AttributeSet

import android.view.View

import lombok.Setter

/**
 * @author AaronGitHubCode
 * @version pre-alpha.0.0.1
 *
 * Cuadro simple para notificar al usuario de una manera más interactiva con la aplicación.
 *
 * La clase puede ser heredada si alguien quiere modificar o añadir alguna funcionalidad.
 *
 * El tamaño por defecto debe variar según si la aplicación está siendo ejecutada en un teléfono, un televisor o un equipo de escritorio.
 * */
open class KHMessageBox(private val context: Context, attrs: AttributeSet) : View(context, attrs) {

    /*
    * Por si estas constantes son necesarias por código escrito en Java.
    * */
    companion object {
        @JvmStatic
        val DEFAULT_MESSAGE_BOX_WIDTH: Int = 300
        @JvmStatic
        val DEFAULT_MESSAGE_BOX_HEIGHT: Int = 200
    }

    private val width: Int = attrs.getAttributeIntValue("kh", "box_width", 0)
    private val height: Int = attrs.getAttributeIntValue("kh", "box_height", 0)

    private var show: Boolean = true

    /**
    * Implementación pensada para usarla con código Java.
    * @throws NullPointerException
    * */
    @Setter
    private var mOnCloseListener: OnClickListener? = null

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) = setMeasuredDimension(width, height)

    override fun onDraw(canvas: Canvas) {
        val resources = context.resources

        super.onDraw(canvas)

        if (show) {
            if (resources.getBoolean(R.bool.tv)) {
                /*
                * TODO: Implementación TV
                * */
            } else if (resources.getBoolean(R.bool.desktop)) {
                /*
                * TODO: Implementación Escritorio
                * */
            } else {
                /*
                * TODO: Implementación dispositivo móvil
                * */
            }
        }
    }
}