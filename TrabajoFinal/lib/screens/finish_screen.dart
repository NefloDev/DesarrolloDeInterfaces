import 'package:animated_widgets/animated_widgets.dart';
import 'package:auto_size_text/auto_size_text.dart';
import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom_colors.dart';
import 'package:trabajo_final/constants/custom_strings.dart';
import 'package:trabajo_final/screens/main_screen.dart';
import 'package:trabajo_final/widgets/custom_menu_button.dart';
import 'package:trabajo_final/widgets/diagonal_box.dart';

class FinishScreen extends StatefulWidget{
  const FinishScreen({super.key});

  @override
  State<StatefulWidget> createState() => FinishScreenState();

}

class FinishScreenState extends State<FinishScreen>{

  late bool animate;
  @override
  void initState() {
    super.initState();
    animate = true;
  }

  @override
  Widget build(BuildContext context) {
    return PopScope(
      canPop: false,
      child: Scaffold(
          body: Stack(
              children: [
                Positioned(
                    top: 150,
                    left: 55,
                    child: ScaleAnimatedWidget.tween(
                        enabled: animate,
                        scaleDisabled: 0.0,
                        scaleEnabled: 1.0,
                        curve: Curves.fastEaseInToSlowEaseOut,
                        duration: const Duration(milliseconds: 300),
                        child: const DiagonalBox(
                            angle: -15,
                            height: 150,
                            width: 330,
                            color: CustomColors.mainPurple
                        )
                    )
                ),
                Positioned(
                    top: 225,
                    left: 70,
                    right: 70,
                    child: ScaleAnimatedWidget.tween(
                        enabled: animate,
                        scaleDisabled: 0.0,
                        scaleEnabled: 1.0,
                        curve: Curves.fastEaseInToSlowEaseOut,
                        duration: const Duration(milliseconds: 300),
                        child: const AutoSizeText(
                          CustomStrings.noCardsLeft,
                          textAlign: TextAlign.center,
                          maxLines: 2,
                          style: TextStyle(
                              color: Colors.white,
                              fontSize: 34,
                              fontWeight: FontWeight.bold
                          ),
                        )
                    )
                ),
                Positioned(
                    top: 350,
                    left: 30,
                    child: ScaleAnimatedWidget.tween(
                        enabled: animate,
                        scaleDisabled: 0.0,
                        scaleEnabled: 1.0,
                        curve: Curves.fastEaseInToSlowEaseOut,
                        duration: const Duration(milliseconds: 300),
                        child: const DiagonalBox(
                          angle: 0,
                          height: 220,
                          width: 330,
                          color: CustomColors.mainBlue,
                          alignment: Alignment.center,
                          padding: 20,
                          child: Padding(
                            padding: EdgeInsets.symmetric(horizontal: 15),
                            child: AutoSizeText(
                              CustomStrings.finishGameString,
                              textAlign: TextAlign.center,
                              style: TextStyle(
                                  color: Colors.white,
                                  fontSize: 20
                              ),
                            ),
                          ),
                        )
                    )
                ),
                Positioned(
                    bottom: 100,
                    left: 100,
                    right: 100,
                    child: TranslationAnimatedWidget.tween(
                      enabled: animate,
                      translationDisabled: const Offset(0, 300),
                      translationEnabled: const Offset(0,0),
                      curve: Curves.bounceIn,
                      child: CustomMenuButton(
                        height: 70,
                        width: 150,
                        buttonColor: CustomColors.mainOrange,
                        text: const Text(
                          CustomStrings.goToMenuButtonText,
                          style: TextStyle(
                              color: Colors.white,
                              fontSize: 16
                          ),
                        ),
                        alignment: Alignment.center,
                        customFunction: () async {
                          setState(() {
                            animate = false;
                          });
                          await Future.delayed(const Duration(milliseconds: 500), (){
                            Navigator.push(context, PageRouteBuilder(pageBuilder: (_,__,___) => const MainScreen()));
                          });
                        },
                      ),
                    )
                )
              ]
          )
      ),
    );
  }
}