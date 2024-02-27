import "dart:math";

import "package:animated_widgets/animated_widgets.dart";
import "package:flutter/material.dart";
import "package:trabajo_final/constants/custom_colors.dart";
import "package:trabajo_final/models/user.dart";
import "package:trabajo_final/screens/card_list_screen.dart";
import "package:trabajo_final/screens/game_screen.dart";
import "package:trabajo_final/screens/play_screen.dart";
import "package:trabajo_final/widgets/custom_icon_button.dart";
import "package:trabajo_final/widgets/custom_menu_button.dart";
import "package:trabajo_final/widgets/custom_shaped_box.dart";
import "package:trabajo_final/widgets/diagonal_box.dart";

const int codeLength = 4;
const firstCharUppercase = 65;

String generateRandomCode(){
  Random rand = Random();
  String temp = "";

  for(int i = 0; i < codeLength; i++){
    temp += String.fromCharCode(rand.nextInt(26) + firstCharUppercase);
  }

  return temp;
}

class WaitingRoomScreen extends StatefulWidget {
  const WaitingRoomScreen({super.key, this.code = "ABCD"});

  final String code;

  @override
  State<StatefulWidget> createState() => WaitingRoomScreenState();
}

class WaitingRoomScreenState extends State<WaitingRoomScreen>{

  int delay = 100;
  int move = -400;
  late bool animate;
  late bool animate2;
  late bool animateHostStart;

  List<User> users = [
    User("Player 1"),
    User("Player 2"),
    User("Player 3"),
    User("Player 4"),
    User("Player 5"),
    User("Player 6"),
    User("Player 7"),
    User("Player 8"),
    User("Player 9"),
    User("Player 10"),
    User("Player 11"),
    User("Player 12"),
    User("Player 13"),
    User("Player 14")
  ];

  @override
  void initState(){
    super.initState();
    animate = true;
    animate2 = false;
    animateHostStart = false;
    Future.delayed(const Duration(seconds: 1), (){
      setState(() {
        animateHostStart = true;
      });
    });
  }

  @override
  Widget build(BuildContext context) {
    return PopScope(
      canPop: false,
      child: Scaffold(
          body: Stack(
              children: [
                Positioned(
                  top: -100,
                  child: TranslationAnimatedWidget.tween(
                    enabled: animate,
                    curve: Curves.easeOut,
                    translationDisabled: const Offset(0, -350),
                    translationEnabled: const Offset(0, 0),
                    child: DiagonalBox(
                      angle: -10,
                      height: 350,
                      width: (MediaQuery.of(context).size.width + 100),
                      color: CustomColors.bgLight,
                      shadow: false,
                    ),
                  ),
                ),
                Positioned(
                  top: 120,
                  left: 40,
                  child: TranslationAnimatedWidget.tween(
                    enabled: animate2,
                    curve: Curves.fastEaseInToSlowEaseOut,
                    translationDisabled: const Offset(0, 0),
                    translationEnabled: const Offset(0, -200),
                    child: TranslationAnimatedWidget.tween(
                      enabled: animate,
                      curve: Curves.bounceOut,
                      translationDisabled: const Offset(0, -200),
                      translationEnabled: const Offset(0, 0),
                      child: const DiagonalBox(
                        alignment: Alignment.centerLeft,
                        padding: 0,
                        angle: 8,
                        height: 80,
                        width: 250,
                        color: CustomColors.mainOrange,
                        child: Padding(
                          padding: EdgeInsets.only(left: 20),
                          child: Text("Código de\npartida",
                            textAlign: TextAlign.center,
                            style: TextStyle(
                                color: CustomColors.bgDark
                            ),
                          ),
                        ),
                      ),
                    ),
                  ),
                ),
                Positioned(
                    left: 160,
                    top: 110,
                    child: TranslationAnimatedWidget.tween(
                      enabled: animate2,
                      curve: Curves.fastEaseInToSlowEaseOut,
                      translationDisabled: const Offset(0, 0),
                      translationEnabled: const Offset(0, -200),
                      child: TranslationAnimatedWidget.tween(
                        enabled: animate,
                        curve: Curves.bounceOut,
                        translationDisabled: const Offset(0, -200),
                        translationEnabled: const Offset(0, 0),
                        delay: const Duration(milliseconds: 200),
                        child: Text(
                            widget.code,
                          style: const TextStyle(
                            fontSize: 34,
                            color: Colors.white,
                            fontWeight: FontWeight.bold
                          ),
                        ),
                      ),
                    )
                ),
                Positioned(
                  top: 280,
                  left: 0,
                  right: 0,
                  bottom: 0,
                  child: SingleChildScrollView(
                    child: Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: List.generate(users.length, (i){
                        return Padding(
                          padding: const EdgeInsets.only(bottom: 15),
                          child: TranslationAnimatedWidget.tween(
                            enabled: animate2,
                            curve: Curves.fastEaseInToSlowEaseOut,
                            translationDisabled: const Offset(0,0),
                            translationEnabled: Offset(move*pow(-1.0, i) as double, 0),
                            delay: Duration(milliseconds: (delay * i) + 500),
                            child: TranslationAnimatedWidget.tween(
                              enabled: animate,
                              curve: Curves.fastEaseInToSlowEaseOut,
                              translationDisabled: Offset(move*pow(-1.0, i) as double,0),
                              translationEnabled: const Offset(0, 0),
                              delay: Duration(milliseconds: (delay * i)),
                              duration: const Duration(milliseconds: 500),
                              child: CustomShapedBox(
                                radius: const BorderRadius.all(Radius.circular(50)),
                                height: 50,
                                width: 350,
                                color: CustomColors.alternateColors[i],
                                alignment: Alignment.center,
                                child: Text(users[i].name.toUpperCase(),
                                  style: const TextStyle(
                                      fontWeight: FontWeight.bold,
                                      fontSize: 22
                                  )
                                )
                              )
                            )
                          )
                        );
                      })
                    )
                  )
                ),
                Positioned(
                  top: 50,
                  right: -210,
                  child: TranslationAnimatedWidget.tween(
                    enabled: animate,
                    curve: Curves.easeOut,
                    translationDisabled: const Offset(0, 0),
                    translationEnabled: const Offset(-100, 0),
                    child: CustomMenuButton(
                        height: 50,
                        width: 200,
                        buttonColor: CustomColors.mainFuchsia,
                        text: const Text("Cartas",
                            style: TextStyle(
                                fontSize: 16
                            )
                        ),
                        customFunction: () async {
                          setState(() {
                            animate = false;
                            animate2 = true;
                            animateHostStart = false;
                          });
                          await Future.delayed(const Duration(milliseconds: 600), (){
                            Navigator.push(context, PageRouteBuilder(pageBuilder: (_,__,___) => const CardListScreen()))
                                .then((value){
                                  setState(() {
                                    animate2 = false;
                                    animate = true;
                                    animateHostStart = true;
                                  });
                            });
                          });
                        },
                        alignment: Alignment.centerLeft
                    ),
                  ),
                ),
                Positioned(
                    top: 220,
                    left: 0,
                    right: 0,
                    child: TranslationAnimatedWidget.tween(
                      enabled: animate,
                      translationDisabled: const Offset(-400,0),
                      translationEnabled: const Offset(0,0),
                      curve: Curves.fastEaseInToSlowEaseOut,
                      child: OpacityAnimatedWidget.tween(
                        opacityDisabled: 0.0,
                        opacityEnabled: 1.0,
                        child: Text("${users.length}/14 Jugadores en la sala:",
                            textAlign: TextAlign.center,
                            style: const TextStyle(
                                color: Colors.white,
                                fontSize: 22
                            )
                        ),
                      ),
                    )
                ),
                Positioned(
                  top: 100,
                  left: 20,
                  child: TranslationAnimatedWidget.tween(
                    enabled: animate2,
                    curve: Curves.fastEaseInToSlowEaseOut,
                    translationDisabled: const Offset(0, 0),
                    translationEnabled: const Offset(0, -400),
                    child: TranslationAnimatedWidget.tween(
                      enabled: animate,
                      curve: Curves.bounceOut,
                      translationDisabled: const Offset(0, -400),
                      translationEnabled: const Offset(0, 0),
                      delay: const Duration(milliseconds: 200),
                      child: CustomIconButton(
                          angle: 0,
                          buttonSize: 40,
                          color: Colors.white,
                          icon: const Icon(
                              Icons.arrow_back,
                              color: CustomColors.bgLight,
                              size: 20),
                          onPressed: () async {
                            setState(() {
                              animate = false;
                              animate2 = true;
                              animateHostStart = false;
                            });
                            await Future.delayed(const Duration(milliseconds: 600), (){
                              Navigator.pop(context, PageRouteBuilder(pageBuilder: (_,__,___) => const PlayScreen()));
                            }).then((value){
                              setState(() {
                                animate2 = false;
                              });
                            });
                          }
                      ),
                    ),
                  ),
                ),
                Positioned(
                  top: 140,
                  right: 65,
                  child: ScaleAnimatedWidget.tween(
                    enabled: animate2,
                    scaleDisabled: 1.0,
                    scaleEnabled: 0.0,
                    curve: Curves.fastEaseInToSlowEaseOut,
                    duration: const Duration(milliseconds: 300),
                    child: ScaleAnimatedWidget.tween(
                      enabled: animateHostStart,
                      scaleDisabled: 0.0,
                      scaleEnabled: 1.0,
                      curve: Curves.fastEaseInToSlowEaseOut,
                      duration: const Duration(milliseconds: 300),
                      child: CustomIconButton(
                          angle: 0,
                          color: CustomColors.mainBlue,
                          icon: const Icon(
                              Icons.play_arrow,
                              color: Colors.white,
                              size: 35),
                          onPressed: () async {
                            setState(() {
                              animate = false;
                              animate2 = true;
                              animateHostStart = false;
                            });
                            await Future.delayed(const Duration(milliseconds: 600), (){
                              Navigator.push(context, PageRouteBuilder(pageBuilder: (_,__,___) => GameScreen()))
                                  .then((value){
                                    setState(() {
                                      animate2 = false;
                                      animate = true;
                                      animateHostStart = true;
                                    });
                                  });
                            });
                          }
                      ),
                    ),
                  ),
                )
              ]
          )
      ),
    );
  }
}
