#!/bin/zsh

echo "Stopping Appium server..."
pkill -f appium

# Kill the emulator (all running emulators)
echo "Closing Android emulator(s)..."
adb -s emulator-5554 emu kill 2>/dev/null || true

# Clean Maven build artifacts
echo "Cleaning Maven build artifacts..."
mvn clean

echo "Environment stopped and cleaned."
