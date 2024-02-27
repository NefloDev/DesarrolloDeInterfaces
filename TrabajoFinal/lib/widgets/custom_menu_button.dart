import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom_colors.dart';

class CustomMenuButton extends StatelessWidget {
  const CustomMenuButton({
    super.key, this.left, this.right, this.top, this.bottom, required this.height, required this.width, required this.buttonColor, required this.text, this.customFunction, required this.alignment,
  });
  final double? left;
  final double? right;
  final double? top;
  final double? bottom;
  final double height;
  final double width;
  final Color buttonColor;
  final Text text;
  final Function()? customFunction;
  final Alignment alignment;

  @override
  Widget build(BuildContext context) {
    return Positioned(
        left: left,
        right: right,
        top: top,
        bottom: bottom,
        child: SizedBox(
          height: height,
          width: width,
          child: ElevatedButton(
            onPressed: customFunction,
            style: ButtonStyle(
                backgroundColor: MaterialStatePropertyAll(buttonColor),
                foregroundColor: const MaterialStatePropertyAll(CustomColors.bgBlue),
                elevation: const MaterialStatePropertyAll(10),
                shape: MaterialStatePropertyAll(RoundedRectangleBorder(
                    borderRadius: BorderRadius.circular(25)
                )),
                textStyle: const MaterialStatePropertyAll(TextStyle(
                    fontSize: 30,
                    fontWeight: FontWeight.bold
                )),
                alignment: alignment
            ),
            child: text,
          ),
        )
    );
  }
}