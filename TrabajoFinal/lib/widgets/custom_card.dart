import 'package:flutter/material.dart';

class CustomCard extends StatelessWidget{
  const CustomCard({super.key, required this.height, required this.width, required this.color, required this.child});

  final double height;
  final double width;
  final Color color;
  final Widget child;

  @override
  Widget build(BuildContext context) {
    return ClipRRect(
      borderRadius: BorderRadius.circular(20),
      child: Container(
        height: height,
        width: width,
        color: color,
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: child,
        )
      ),
    );
  }

}