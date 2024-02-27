import 'dart:math';

import 'package:animated_widgets/animated_widgets.dart';
import 'package:auto_size_text/auto_size_text.dart';
import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom_colors.dart';
import 'package:trabajo_final/constants/custom_strings.dart';
import 'package:trabajo_final/screens/finish_screen.dart';
import 'package:trabajo_final/widgets/custom_card.dart';
import 'package:trabajo_final/widgets/custom_menu_button.dart';
import 'package:trabajo_final/widgets/diagonal_box.dart';
import 'package:trabajo_final/widgets/flipped_card.dart';

class GameScreen extends StatefulWidget{
  GameScreen({super.key, this.cardList});
  List<String>? cardList;

  @override
  State<StatefulWidget> createState() => GameScreenState();
}

class GameScreenState extends State<GameScreen>{

  late int card;
  late int stupid;
  late int reveal;
  late bool animate;
  late bool animate2;
  late String nextRoundOrFinish;

  @override
  void initState() {
    super.initState();
    animate = true;
    animate2 = false;
    widget.cardList ??= CustomStrings.cardList.toList();
    nextRoundOrFinish = widget.cardList!.length == 1
        ? CustomStrings.finishGame
        : CustomStrings.nextRound;
    generateAll();
  }

  int generateRandom(int max){
    Random r = Random();
    return r.nextInt(max);
  }

  generateAll(){
    setState(() {
      card = generateRandom(widget.cardList!.length);
      stupid = generateRandom(CustomStrings.stupidList.length);
      reveal = generateRandom(CustomStrings.reveal.length);
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
                top: 60,
                left: 50,
                right: 50,
                child: ScaleAnimatedWidget.tween(
                  enabled: animate,
                  scaleDisabled: 0.0,
                  scaleEnabled: 1.0,
                  curve: Curves.fastEaseInToSlowEaseOut,
                  duration: const Duration(milliseconds: 100),
                  child: const DiagonalBox(
                    angle: -4,
                    height: 80,
                    width: 300,
                    color: CustomColors.mainRed,
                  ),
                )
            ),
            Positioned(
                top: 85,
                left: 80,
                right: 80,
                child: ScaleAnimatedWidget.tween(
                  enabled: animate,
                  scaleDisabled: 0.0,
                  scaleEnabled: 1.0,
                  curve: Curves.fastEaseInToSlowEaseOut,
                  duration: const Duration(milliseconds: 100),
                  child: AutoSizeText(
                    CustomStrings.stupidList[stupid],
                    minFontSize: 10,
                    maxLines: 2,
                    textAlign: TextAlign.center,
                    style: const TextStyle(
                      color: Colors.white,
                      fontSize: 18
                    ),
                  )
                )
            ),
            Positioned(
                top: 145,
                left: 100,
                right: 100,
                child: ScaleAnimatedWidget.tween(
                  enabled: animate,
                  scaleDisabled: 0.0,
                  scaleEnabled: 1.0,
                  curve: Curves.fastEaseInToSlowEaseOut,
                  duration: const Duration(milliseconds: 100),
                  child: const DiagonalBox(
                    angle: 4,
                    height: 40,
                    width: 100,
                    color: CustomColors.mainBlue,
                  ),
                )
            ),
            Positioned(
                top: 150,
                left: 80,
                right: 80,
                child: ScaleAnimatedWidget.tween(
                  enabled: animate,
                    scaleDisabled: 0.0,
                    scaleEnabled: 1.0,
                    curve: Curves.fastEaseInToSlowEaseOut,
                    duration: const Duration(milliseconds: 100),
                    child: Text(
                      "Quedan ${widget.cardList!.length} cartas",
                      textAlign: TextAlign.center,
                      style: const TextStyle(
                          color: Colors.white,
                          fontSize: 14
                      ),
                    )
                )
            ),
            Positioned(
                top: 250,
                left: 40,
                right: 40,
                child: TranslationAnimatedWidget.tween(
                  enabled: animate,
                  translationDisabled: const Offset(600, 0),
                  translationEnabled: const Offset(0,0),
                  curve: Curves.fastEaseInToSlowEaseOut,
                  child: FlippedCard(
                    frontWidget: CustomCard(
                        height: 450,
                        width: 300,
                        color: Colors.black,
                        child: Center(
                          child: Column(
                            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                            children: [
                              const Text(
                                CustomStrings.mainTitleText,
                                textAlign: TextAlign.center,
                                style: TextStyle(
                                    color: Colors.grey,
                                    fontSize: 30,
                                    fontWeight: FontWeight.bold
                                ),
                              ),
                              Text(
                                widget.cardList![card].toUpperCase(),
                                textAlign: TextAlign.center,
                                style: const TextStyle(
                                    color: Colors.white,
                                    fontSize: 26
                                ),
                              )
                            ],
                          ),
                        )
                    ),
                    backWidget: CustomCard(
                        height: 450,
                        width: 300,
                        color: Colors.white,
                        child: Center(
                          child: Column(
                            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                            children: [
                              const Text(
                                CustomStrings.mainTitleText,
                                textAlign: TextAlign.center,
                                style: TextStyle(
                                    color: Colors.grey,
                                    fontSize: 30,
                                    fontWeight: FontWeight.bold
                                ),
                              ),
                              Text(
                                CustomStrings.reveal[reveal],
                                textAlign: TextAlign.center,
                                style: const TextStyle(
                                    color: Colors.black,
                                    fontSize: 26
                                ),
                              ),
                              Row(
                                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                                children: [
                                  Image.asset("assets/images/shot.png", scale: 8),
                                  Image.asset("assets/images/shot.png", scale: 8),
                                  Image.asset("assets/images/shot.png", scale: 8)
                                ],
                              ),
                              CustomMenuButton(
                                  height: 50,
                                  width: 200,
                                  buttonColor: CustomColors.mainPurple,
                                  text: Text(
                                    nextRoundOrFinish,
                                    style: const TextStyle(
                                      color: Colors.white,
                                      fontSize: 16
                                    ),
                                  ),
                                  alignment: Alignment.center,
                                customFunction: () async {
                                    setState(() {
                                      animate = false;
                                      animate2 = true;
                                    });
                                    await Future.delayed(const Duration(milliseconds: 500), (){
                                      if(widget.cardList!.length > 1){
                                        setState(() {
                                          widget.cardList!.removeAt(card);
                                        });
                                        Navigator.pushReplacement(context,
                                            PageRouteBuilder(pageBuilder: (_,__,___) => GameScreen(cardList: (widget.cardList))));
                                      }else{
                                        Navigator.push(context, PageRouteBuilder(pageBuilder: (_,__,___) => const FinishScreen()));
                                      }
                                    });
                                },
                              )
                            ],
                          ),
                        )
                    ),
                  ),
                )
            )
          ],
        ),
      ),
    );
  }

}