import 'dart:math';

import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom-colors.dart';

class JoinNewGameCard extends StatefulWidget{
  const JoinNewGameCard({super.key});

  @override
  State<StatefulWidget> createState() => JoinNewGameCardState();
}

class JoinNewGameCardState extends State<JoinNewGameCard>{
  final codeController = TextEditingController();
  @override
  Widget build(BuildContext context) {
    return ClipRRect(
      borderRadius: BorderRadius.circular(20),
      child: Container(
        height: 400,
        width: 250,
        color: Colors.white,
        child: Padding(
          padding: const EdgeInsets.all(20.0),
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
              const Text("Unirse a una partida existente",
                textAlign: TextAlign.center,
                style: TextStyle(
                    fontSize: 25,
                    color: Colors.black
                ),
              ),
              TextFormField(
                controller: codeController,
                decoration: const InputDecoration(
                    labelText: "Código"
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
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 20),
                child: Transform(
                  transform: Matrix4.identity()..rotateZ(pi),
                  alignment: Alignment.center,
                  child: IconButton(
                      onPressed: (){},
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
          )
        )
      )
    );
  }
}