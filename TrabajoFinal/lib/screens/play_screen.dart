import 'dart:math';

import 'package:animated_widgets/animated_widgets.dart';
import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom_colors.dart';
import 'package:trabajo_final/constants/custom_strings.dart';
import 'package:trabajo_final/screens/main_screen.dart';
import 'package:trabajo_final/screens/waiting_room_screen.dart';
import 'package:trabajo_final/widgets/custom_card.dart';
import 'package:trabajo_final/widgets/custom_icon_button.dart';
import 'package:trabajo_final/widgets/create_new_game_card.dart';
import 'package:trabajo_final/widgets/custom_menu_button.dart';
import 'package:trabajo_final/widgets/diagonal_box.dart';
import 'package:trabajo_final/widgets/flipped_card.dart';

class PlayScreen extends StatefulWidget {
  const PlayScreen({super.key});

  @override
  State<StatefulWidget> createState() => PlayScreenState();
}

class PlayScreenState extends State<PlayScreen>{
  late bool animate;
  final codeController = TextEditingController();

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
        body: Center(
          child: SingleChildScrollView(
            child: Stack(
              children: [
                Container(
                  height: MediaQuery.of(context).size.height,
                ),
                Positioned(
                  top: 50,
                  left: -700,
                  child: TranslationAnimatedWidget.tween(
                    curve: Curves.fastEaseInToSlowEaseOut,
                    enabled: animate,
                    translationDisabled: const Offset(0,0),
                    translationEnabled: const Offset(650, 0),
                    duration: const Duration(milliseconds: 500),
                    child: CustomMenuButton(
                        height: 120,
                        width: 400,
                        buttonColor: CustomColors.mainCyan,
                        text: const Text(
                          CustomStrings.jugarButtonText,
                          style: TextStyle(color: CustomColors.bgDark, fontSize: 40, fontWeight: FontWeight.bold),
                        ),
                        customFunction: () {},
                        alignment: Alignment.centerRight),
                  ),
                ),
                Positioned(
                  top: -40,
                  left: -260,
                  child: RotationAnimatedWidget.tween(
                    curve: Curves.fastEaseInToSlowEaseOut,
                    enabled: animate,
                    rotationDisabled: Rotation.deg(x: 0),
                    rotationEnabled: Rotation.deg(z:8),
                    delay: const Duration(milliseconds: 400),
                    child: TranslationAnimatedWidget.tween(
                      curve: Curves.fastEaseInToSlowEaseOut,
                      enabled: animate,
                      translationDisabled: const Offset(0,0),
                      translationEnabled: const Offset(120, 0),
                      delay: const Duration(milliseconds: 400),
                      child: DiagonalBox(
                          angle: 0,
                          height: (MediaQuery.of(context).size.height + 20),
                          width: 200,
                          color: CustomColors.mainPurple
                      ),
                    ),
                  ),
                ),
                Positioned(
                  top: 40,
                  left: -110,
                  child: TranslationAnimatedWidget.tween(
                      curve: Curves.fastEaseInToSlowEaseOut,
                      enabled: animate,
                      delay: const Duration(milliseconds: 400),
                      translationDisabled: const Offset(0,0),
                      translationEnabled: const Offset(130, 0),
                      child: CustomIconButton(
                        onPressed: () async {
                          setState(() {
                            animate = false;
                          });
                          await Future.delayed(const Duration(milliseconds: 500), (){
                            Navigator.pop(context, PageRouteBuilder(pageBuilder: (_,__,___) => const MainScreen()));
                          });
                        }
                      )
                  ),
                ),
                Positioned(
                  top: 250,
                  right: -300,
                  child: TranslationAnimatedWidget.tween(
                      curve: Curves.fastEaseInToSlowEaseOut,
                      enabled: animate,
                      delay: const Duration(milliseconds: 400),
                      translationDisabled: const Offset(0,0),
                      translationEnabled: const Offset(-320, 0),
                      child: FlippedCard(
                          frontWidget: CreateNewGameCard(
                            onPressed: () async{
                              setState(() {
                                animate = false;
                              });
                              await Future.delayed(const Duration(milliseconds: 500), (){
                                Navigator.push(context, PageRouteBuilder(pageBuilder: (_,__,___) => const WaitingRoomScreen()))
                                .then((value){
                                  setState(() {
                                    animate = true;
                                  });
                                });
                              });

                            },
                          ),
                          backWidget: CustomCard(
                              height: 400,
                              width: 250,
                              color: Colors.white,
                              child: SingleChildScrollView(
                                child: Column(
                                    mainAxisSize: MainAxisSize.max,
                                    mainAxisAlignment: MainAxisAlignment.spaceAround,
                                    children: [
                                      Row(
                                        mainAxisAlignment: MainAxisAlignment.end,
                                        children: [
                                          Transform(
                                              transform: Matrix4.identity()..rotateZ(pi),
                                              alignment: Alignment.center,
                                              child: const Icon(Icons.refresh, color: Colors.black,)
                                          )
                                        ],
                                      ),
                                      const Text("Quién crees que...",
                                        style: TextStyle(
                                            color: Colors.grey
                                        ),
                                      ),
                                      const Padding(
                                        padding: EdgeInsets.all(10),
                                        child: Text("Unirse a una partida existente",
                                          textAlign: TextAlign.center,
                                          style: TextStyle(
                                              fontSize: 25,
                                              color: Colors.black
                                          ),
                                        ),
                                      ),
                                      Padding(
                                        padding: const EdgeInsets.all(10),
                                        child: TextFormField(
                                          controller: codeController,
                                          decoration: const InputDecoration(
                                              labelText: "Código(AAAA)"
                                          ),
                                          style: const TextStyle(
                                              color: Colors.black
                                          ),
                                          onChanged: (val) {
                                            codeController.value = TextEditingValue(
                                                text: val.toUpperCase(),
                                                selection: codeController.selection
                                            );
                                          },
                                          autovalidateMode: AutovalidateMode.onUserInteraction,
                                          validator: (value){
                                            if(value == null || value.isEmpty || value.length != 4){
                                              return "El código debe ser\nde 4 carácteres";
                                            }
                                            return null;
                                          },
                                        ),
                                      ),
                                      Padding(
                                          padding: const EdgeInsets.symmetric(vertical: 20),
                                          child: Transform(
                                              transform: Matrix4.identity()..rotateZ(pi),
                                              alignment: Alignment.center,
                                              child: IconButton(
                                                  onPressed: () async {
                                                    if(codeController.text.isNotEmpty && codeController.text.length == 4){
                                                      setState(() {
                                                        animate = false;
                                                      });
                                                      await Future.delayed(const Duration(milliseconds: 500), (){
                                                        Navigator.push(context, PageRouteBuilder(pageBuilder: (_,__,___) =>
                                                            WaitingRoomScreen(code: codeController.text)))
                                                            .then((value){
                                                              setState(() {
                                                                animate = true;
                                                              });
                                                        });
                                                      });
                                                    }
                                                  },
                                                  icon: const Icon(Icons.arrow_back_ios_new,
                                                    size: 40,
                                                  ),
                                                  color: Colors.white,
                                                  style: const ButtonStyle(
                                                      backgroundColor: MaterialStatePropertyAll(CustomColors.translucentBlack)
                                                  )
                                              )
                                          )
                                      )
                                    ]
                                ),
                              )
                          )
                    )
                  )
                )
              ]
            )
          )
        )
      ),
    );
  }
}
