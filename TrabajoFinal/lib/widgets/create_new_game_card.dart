import 'dart:math';

import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom-colors.dart';

class CreateNewGameCard extends StatelessWidget{
  const CreateNewGameCard({super.key, required this.onPressed});

  final Function() onPressed;

  @override
  Widget build(BuildContext context) {
    return ClipRRect(
      borderRadius: BorderRadius.circular(20),
      child: Container(
        height: 400,
        width: 250,
        color: Colors.black,
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisSize: MainAxisSize.max,
            mainAxisAlignment: MainAxisAlignment.spaceAround,
            children: [
              const Row(
                mainAxisAlignment: MainAxisAlignment.end,
                children: [
                  Icon(Icons.refresh,
                  color: Colors.white,)
                ],
              ),
              const Text("Quién crees que...",
                style: TextStyle(
                    color: Colors.grey
                ),
              ),
              const Text("Crear una partida nueva",
                textAlign: TextAlign.center,
                style: TextStyle(
                    fontSize: 25,
                    color: Colors.white
                ),
              ),
              Padding(
                padding: const EdgeInsets.symmetric(vertical: 20),
                child: Transform(
                  transform: Matrix4.identity()..rotateZ(pi),
                  alignment: Alignment.center,
                  child: IconButton(
                      onPressed: onPressed,
                      icon: const Icon(Icons.arrow_back_ios_new,
                        size: 40,
                      ),
                      color: Colors.black,
                      style: const ButtonStyle(
                          backgroundColor: MaterialStatePropertyAll(CustomColors.translucentWhite)
                      )
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }

}