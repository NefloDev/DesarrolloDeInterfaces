import 'dart:math';

import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom-colors.dart';

class CustomIconButton extends StatelessWidget {
  const CustomIconButton({
    super.key, this.left, this.right, this.top, this.bottom, required this.onPressed,
    this.icon = const Icon(Icons.u_turn_left, color: Colors.white, size: 50,),
    this.color = CustomColors.translucentBlack, this.angle = 90, this.buttonSize = 70,
  });
  final double? left;
  final double? right;
  final double? top;
  final double? bottom;
  final Icon icon;
  final Function() onPressed;
  final double angle;
  final Color color;
  final double buttonSize;

  @override
  Widget build(BuildContext context) {
    return Positioned(
        height: buttonSize,
        width: buttonSize,
        top: top,
        left: left,
        right: right,
        bottom: bottom,
        child: Transform(
          alignment: Alignment.center,
          transform: Matrix4.identity()..rotateZ(angle * pi / 180),
          child: IconButton(
            onPressed: onPressed,
            icon: icon,
            style: ButtonStyle(
                backgroundColor: MaterialStatePropertyAll(color)
            ),
          ),
        )
    );
  }
}