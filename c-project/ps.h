#ifndef _ps_h
#define _ps_h

#include "stdc.h"
#include "types.h"

using player_t = u8;

struct led_color {
    u8 red = 0;
    u8 green = 0;
    u8 blue = 0;
};

typedef struct led_color led_color;

struct DefaultPSColor {
    static constexpr led_color RED = { 255, 0, 0 };
    static constexpr led_color GREEN = { 0, 255, 0 };
    static constexpr led_color BLUE = { 0, 0, 255 };
};

struct ps_controller {
    led_color color;

    player_t player;

    bool active;

    ps_controller(led_color color) : color(color) {};
    ps_controller(u8 red, u8 green, u8 blue) : color({ red, green, blue }) {};
};

typedef struct ps_controller ps_controller;



#endif