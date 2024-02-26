import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class CustomShapedBox extends StatelessWidget{
  const CustomShapedBox({
  super.key, this.left, this.right, this.top, this.bottom, required this.height,
    required this.width, required this.color, required this.alignment, this.child,
    this.radius = const BorderRadius.all(Radius.circular(0)),
});
final double? left;
final double? right;
final double? top;
final double? bottom;
final double height;
final double width;
final Color color;
final Widget? child;
final Alignment alignment;
final BorderRadius radius;

@override
Widget build(BuildContext context) {
  return Positioned(
      left: left,
      right: right,
      top: top,
      bottom: bottom,
      child: ClipRRect(
        borderRadius: radius,
        child: Container(
          height: height,
          width: width,
          decoration: BoxDecoration(
              color: color,
              boxShadow: const [
                BoxShadow(
                    color: Colors.black,
                    offset: Offset(1.0, 1.0),
                    blurRadius: 10.0
                )
              ]
          ),
          alignment: alignment,
          child: child
        )
      )
  );
}

}