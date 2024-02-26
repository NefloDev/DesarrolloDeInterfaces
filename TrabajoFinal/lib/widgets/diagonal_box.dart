import 'dart:math';

import 'package:flutter/material.dart';

class DiagonalBox extends StatelessWidget {
  const DiagonalBox({
    super.key, this.left, this.right, this.top, this.bottom, this.angle = 10, required this.height, required this.width, required this.color, this.child, this.shadow = true, this.padding = 40, this.alignment,
  });
  final double? left;
  final double? right;
  final double? top;
  final double? bottom;
  final double padding;
  final bool shadow;
  final double angle;
  final double height;
  final double width;
  final Color color;
  final Widget? child;
  final Alignment? alignment;

  @override
  Widget build(BuildContext context) {
    return Positioned(
        left: left,
        right: right,
        top: top,
        bottom: bottom,
        child: Transform(
            transform: Matrix4.identity()..rotateZ(angle * pi / -180),
            child: Container(
                height: height,
                width: width,
                alignment: alignment,
                padding: EdgeInsets.symmetric(vertical: padding),
                decoration: BoxDecoration(
                    color: color,
                    boxShadow: [
                      BoxShadow(
                          color: shadow ? Colors.black : Colors.transparent,
                          offset: const Offset(0.0, 1.0),
                          blurRadius: 5.0
                      )
                    ]
                ),
                child: SizedBox(
                  child: child
                )
            )
        )
    );
  }
}