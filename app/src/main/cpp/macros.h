#pragma once

#include <android/choreographer.h>
#include <android/log.h>
#include <android/sensor.h>
#include <android/native_activity.h>
#include <android/set_abort_message.h>

#define LOG_TAG "native-code"

#define _LOG(priority, fmt, ...) \
  ((void)__android_log_print((priority), (LOG_TAG), (fmt)__VA_OPT__(, ) __VA_ARGS__))

#define LOGE(fmt, ...) _LOG(ANDROID_LOG_ERROR, (fmt)__VA_OPT__(, ) __VA_ARGS__)
#define LOGW(fmt, ...) _LOG(ANDROID_LOG_WARN, (fmt)__VA_OPT__(, ) __VA_ARGS__)
#define LOGI(fmt, ...) _LOG(ANDROID_LOG_INFO, (fmt)__VA_OPT__(, ) __VA_ARGS__)

#define CHECK_NOT_NULL(/* (void*) */ ptr) \
    if (ptr == nullptr)     \
        LOGE("%s", "Null pointer detected!")