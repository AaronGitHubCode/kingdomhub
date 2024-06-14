#include "ps.h"

static inline void controller_memset(ps_controller* controllerptr) {
    memset(controllerptr, 0x0000, sizeof(controllerptr));
}