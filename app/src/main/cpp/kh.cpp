/**
 * Todo el código nativo de la actividad del videojuego
 * irá aquí.
 *
 * Se recomendaría no tener que recurrir a código nativo.
 * */

#include <jni.h>

#include <initializer_list>
#include <memory>

#include <cstdlib>
#include <cassert>
#include <cerrno>
#include <cstdlib>
#include <cstring>

#include "macros.h"
#include "types.h"

static inline engineptr engine_mem(void) {
    engineptr engine = {};
    memset(engine, 0, sizeof(engine));
    return engine;
}

/** Actividad nativa para el juego. (Revisando documentación Android NDK) */

void android_main(struct android_app* state) {
    engineptr e = engine_mem();


}