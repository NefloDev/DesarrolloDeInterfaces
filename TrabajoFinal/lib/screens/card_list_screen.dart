import 'package:animated_widgets/animated_widgets.dart';
import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom_colors.dart';
import 'package:trabajo_final/constants/custom_strings.dart';
import 'package:trabajo_final/screens/waiting_room_screen.dart';
import 'package:trabajo_final/widgets/custom_icon_button.dart';
import 'package:trabajo_final/widgets/custom_menu_button.dart';

class CardListScreen extends StatefulWidget{
  const CardListScreen({super.key});

  @override
  State<StatefulWidget> createState() => CardListScreenState();

}

class CardListScreenState extends State<CardListScreen>{
  int delay = 100;
  late bool animate;
  late bool animate2;

  @override
  void initState() {
    super.initState();
    animate = true;
    animate2 = false;
  }

  Widget _buildInfoDialog(BuildContext context, String contentText) {
    return AlertDialog(
      backgroundColor: Colors.white,
      title: const Text(
        CustomStrings.card,
        textAlign: TextAlign.center,
        style: TextStyle(
          fontSize: 34
        ),
      ),
      content: Column(
        mainAxisSize: MainAxisSize.min,
        children: [
          Container(
            padding: const EdgeInsets.all(20),
            decoration: BoxDecoration(
              borderRadius: BorderRadius.circular(10),
              border: Border.all(color: Colors.black)
            ),
            child: Text(
              contentText.toUpperCase(),
              textAlign: TextAlign.center,
              style: const TextStyle(
                fontSize: 20
              ),
            ),
          ),
        ],
      ),
      actions: [
        CustomIconButton(
            onPressed: (){},
            icon: const Icon(
              Icons.delete_forever,
              color: Colors.white,
              size: 40,
            ),
            angle: 0,
            color: CustomColors.mainRed,
        )
      ],
    );
  }

  Widget _buildCreateDialog(BuildContext context) {
    return AlertDialog(
      backgroundColor: Colors.white,
      title: const Text(
        CustomStrings.newCard,
        textAlign: TextAlign.center,
        style: TextStyle(
            fontSize: 34
        ),
      ),
      content: SingleChildScrollView(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              padding: const EdgeInsets.all(20),
              decoration: BoxDecoration(
                  borderRadius: BorderRadius.circular(10),
                  border: Border.all(color: Colors.black)
              ),
              child: const TextField(
                textCapitalization: TextCapitalization.characters,
                keyboardType: TextInputType.multiline,
                maxLines: null,
                style: TextStyle(
                    fontSize: 20
                ),
              ),
            ),
          ],
        ),
      ),
      actions: [
        CustomIconButton(
          onPressed: (){},
          icon: const Icon(
            Icons.check,
            color: Colors.white,
            size: 40,
          ),
          angle: 0,
          color: Colors.green,
        )
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return PopScope(
      canPop: false,
      child: Scaffold(
          body: Stack(
              children: [
                Positioned(
                    top: 80,
                    left: 50,
                    child: TranslationAnimatedWidget.tween(
                      enabled: animate,
                      translationDisabled: const Offset(0,-1200),
                      translationEnabled: const Offset(0,0),
                      curve: Curves.fastEaseInToSlowEaseOut,
                      duration: const Duration(seconds: 1),
                      child: const ClipOval(
                        child: ColoredBox(
                          color: CustomColors.bgLight,
                          child: SizedBox(
                            height: 1000,
                            width: 800,
                          ),
                        ),
                      ),
                    )
                ),
                Positioned(
                    top: 50,
                    left: 100,
                    right: 20,
                    child: TranslationAnimatedWidget.tween(
                        enabled: animate,
                        translationDisabled: const Offset(0,-300),
                        translationEnabled: const Offset(0,0),
                        curve: Curves.fastEaseInToSlowEaseOut,
                        delay: const Duration(milliseconds: 500),
                        child: const CustomMenuButton(
                            height: 100,
                            width: 200,
                            buttonColor: CustomColors.mainFuchsia,
                            text: Text(CustomStrings.cards),
                            alignment: Alignment.center
                        )
                    )
                ),
                Positioned(
                    top: 65,
                    left: 20,
                    child: TranslationAnimatedWidget.tween(
                        enabled: animate,
                        translationDisabled: const Offset(-200,0),
                        translationEnabled: const Offset(0,0),
                        curve: Curves.fastEaseInToSlowEaseOut,
                        delay: const Duration(seconds: 1),
                        child: CustomIconButton(
                            onPressed: () async {
                              setState(() {
                                animate = false;
                                animate2 = true;
                              });
                              await Future.delayed(const Duration(milliseconds: 1000), (){
                                Navigator.pop(context, PageRouteBuilder(pageBuilder: (_,__,___) => const WaitingRoomScreen()));
                              }).then((value){
                                animate2 = false;
                              });
                            }
                        )
                    )
                ),
                Positioned(
                    top: 180,
                    left: 0,
                    right: -100,
                    bottom: 0,
                    child: SingleChildScrollView(
                        physics: const BouncingScrollPhysics(),
                        child: Column(
                            mainAxisAlignment: MainAxisAlignment.center,
                            children: List.generate(CustomStrings.cardList.length, (i){
                              String card = CustomStrings.cardList[i].toUpperCase();
                              if (card.length > 16){
                                card = "${card.substring(0, 16)}...";
                              }
                              return Padding(
                                  padding: const EdgeInsets.all(8),
                                  child: TranslationAnimatedWidget.tween(
                                    enabled: animate2,
                                    curve: Curves.fastEaseInToSlowEaseOut,
                                    translationDisabled: const Offset(0, 0),
                                    translationEnabled: const Offset(500,0),
                                    delay: Duration(milliseconds: (delay * i) + 500),
                                    child: TranslationAnimatedWidget.tween(
                                      enabled: animate,
                                      curve: Curves.fastEaseInToSlowEaseOut,
                                      translationDisabled: const Offset(500, 0),
                                      translationEnabled: const Offset(0,0),
                                      delay: Duration(milliseconds: (delay * i)),
                                      duration: const Duration(milliseconds: 300),
                                      child: CustomMenuButton(
                                          height: 60,
                                          width: 350,
                                          buttonColor: CustomColors.mainLilac,
                                          alignment: Alignment.centerLeft,
                                          text: Text(card,
                                              style: const TextStyle(
                                                  fontWeight: FontWeight.bold,
                                                  fontSize: 22
                                              )
                                          ),
                                        customFunction: (){
                                            showDialog(
                                                context: context,
                                                builder: (BuildContext context) => _buildInfoDialog(context, CustomStrings.cardList[i]));
                                        },
                                      ),
                                    ),
                                  )
                              );
                            })
                        )
                    )
                ),
                Positioned(
                    bottom: 50,
                    right: 50,
                    child: TranslationAnimatedWidget.tween(
                      enabled: animate,
                      translationDisabled: const Offset(200,0),
                      translationEnabled: const Offset(0,0),
                      delay: const Duration(milliseconds: 1500),
                      curve: Curves.fastEaseInToSlowEaseOut,
                      child: CustomIconButton(
                          onPressed: () {
                            showDialog(
                                context: context,
                                builder: (BuildContext context) => _buildCreateDialog(context)
                            );
                          },
                          icon: const Icon(
                              Icons.add,
                              size: 50,
                              color: CustomColors.bgDark
                          ),
                          color: CustomColors.mainBlue,
                          buttonSize: 90,
                          shadow: true
                      ),
                    )
                )
              ]
          )
      ),
    );
  }
}