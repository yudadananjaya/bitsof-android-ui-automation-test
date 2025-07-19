#!/bin/zsh

# 1. Start the emulator (replace with your AVD name)
echo "Starting Android emulator..."
nohup emulator -avd Medium_Tablet_API_33 -no-snapshot-load > /dev/null 2>&1 &

# Wait for emulator to boot
echo "Waiting for emulator to boot..."
adb wait-for-device
adb shell 'while [[ -z $(getprop sys.boot_completed) ]]; do sleep 1; done;'

# 2. Start Appium server
echo "Starting Appium server..."
appium server --session-override --log-level info > appium.log 2>&1 &

# Wait a few seconds for Appium to start
sleep 5

# 3. Run Maven tests
echo "Running Maven tests..."
mvn clean test

# 4. (Optional) Kill Appium server after tests
pkill -f appium
