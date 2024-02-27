import 'dart:io';

import 'package:animated_widgets/animated_widgets.dart';
import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom_colors.dart';
import 'package:trabajo_final/constants/custom_strings.dart';
import 'package:trabajo_final/screens/play_screen.dart';
import 'package:trabajo_final/widgets/custom_menu_button.dart';
import 'package:trabajo_final/widgets/diagonal_box.dart';

class MainScreen extends StatefulWidget {
  const MainScreen({super.key});

  @override
  State<StatefulWidget> createState() => MainScreenState();
}

class MainScreenState extends State<MainScreen>{
  late bool animate;
  late bool animate2;

  @override
  void initState() {
    super.initState();
    animate = false;
    animate2 = true;
  }

  @override
  Widget build(BuildContext context) {
    return PopScope(
      canPop: false,
      child: Scaffold(
          body: Center(
              child: Stack(children: [
                Positioned(
                  top: 400,
                  left: -700,
                  child: TranslationAnimatedWidget.tween(
                    curve: Curves.fastEaseInToSlowEaseOut,
                    enabled: animate,
                    translationDisabled: const Offset(0,0),
                    translationEnabled: const Offset(-500, 0),
                    child: TranslationAnimatedWidget.tween(
                      curve: Curves.fastEaseInToSlowEaseOut,
                      enabled: animate2,
                      translationDisabled: const Offset(0,0),
                      translationEnabled: const Offset(500, 0),
                      child: CustomMenuButton(
                        height: 100,
                        width: 500,
                        buttonColor: CustomColors.mainCyan,
                        text: const Text(CustomStrings.jugarButtonText, style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold)),
                        customFunction: () async {
                          setState(() {
                            animate = true;
                            animate2 = false;
                          });
                          await Future.delayed(const Duration(milliseconds: 500), () {
                            Navigator.of(context).push(PageRouteBuilder(pageBuilder: (_,__,___) => const PlayScreen())).then((value){
                              setState(() {
                                animate = false;
                                animate2 = true;
                              });
                            });
                          });
                        },
                        alignment: Alignment.centerRight,
                      ),
                    ),
                  ),
                ),
                Positioned(
                  top: -300,
                  left: -25,
                  child: TranslationAnimatedWidget.tween(
                    enabled: animate,
                    curve: Curves.fastEaseInToSlowEaseOut,
                    translationDisabled: const Offset(0,0),
                    translationEnabled: const Offset(0, -400),
                    child: TranslationAnimatedWidget.tween(
                      enabled: animate2,
                      curve: Curves.bounceOut,
                      translationDisabled: const Offset(0,0),
                      translationEnabled: const Offset(0, 400),
                      duration: const Duration(milliseconds: 700),
                      child: DiagonalBox(
                        angle: 8,
                        height: 180,
                        width: MediaQuery.of(context).size.width,
                        color: CustomColors.mainBlue,
                        child: Text(
                            CustomStrings.mainTitleText.toUpperCase(),
                            textAlign: TextAlign.center,
                            style: const TextStyle(
                                fontSize: 34,
                                fontWeight: FontWeight.bold,
                                color: Colors.white
                            )
                        ),
                      ),
                    ),
                  ),
                ),
                Positioned(
                  top: 550,
                  right: -600,
                  child: TranslationAnimatedWidget.tween(
                    curve: Curves.fastEaseInToSlowEaseOut,
                    enabled: animate,
                    translationDisabled: const Offset(0,0),
                    translationEnabled: const Offset(500, 0),
                    child: TranslationAnimatedWidget.tween(
                      curve: Curves.fastEaseInToSlowEaseOut,
                      enabled: animate2,
                      translationDisabled: const Offset(0,0),
                      translationEnabled: const Offset(-500, 0),
                      child: CustomMenuButton(
                        height: 100,
                        width: 300,
                        buttonColor: CustomColors.mainFuchsia,
                        text: const Text(
                          CustomStrings.salirButtonText,
                          style: TextStyle(fontSize: 30, fontWeight: FontWeight.bold),
                        ),
                        customFunction: () => exit(0),
                        alignment: Alignment.centerLeft,
                      ),
                    ),
                  ),
                ),
                Positioned(
                  left: -250,
                  top: 10,
                  child: RotationAnimatedWidget.tween(
                    curve: Curves.fastEaseInToSlowEaseOut,
                    enabled: animate2,
                    rotationDisabled: Rotation.deg(x: 0),
                    rotationEnabled: Rotation.deg(z:-8),
                    delay: const Duration(milliseconds: 200),
                    child: TranslationAnimatedWidget.tween(
                      curve: Curves.fastEaseInToSlowEaseOut,
                      enabled: animate2,
                      translationDisabled: const Offset(0,0),
                      translationEnabled: const Offset(110, 0),
                      delay: const Duration(milliseconds: 200),
                      child: DiagonalBox(
                        angle: 0,
                        height: (MediaQuery.of(context).size.height + 20),
                        width: 200,
                        color: CustomColors.mainPurple,
                      ),
                    ),
                  ),
                ),
                Positioned(
                  top: -70,
                  right: -330,
                  child: RotationAnimatedWidget.tween(
                    curve: Curves.fastEaseInToSlowEaseOut,
                    enabled: animate2,
                    rotationDisabled: Rotation.deg(x: 0),
                    rotationEnabled: Rotation.deg(z:-15),
                    delay: const Duration(milliseconds: 200),
                    child: TranslationAnimatedWidget.tween(
                      curve: Curves.fastEaseInToSlowEaseOut,
                      enabled: animate2,
                      translationDisabled: const Offset(0,0),
                      translationEnabled: const Offset(-110, 0),
                      delay: const Duration(milliseconds: 200),
                      child: DiagonalBox(
                        angle: 0,
                        height: (MediaQuery.of(context).size.height + 20),
                        width: 200,
                        color: CustomColors.mainPurple,
                      ),
                    ),
                  ),
                ),
              ])
          )
      ),
    );
  }
}
