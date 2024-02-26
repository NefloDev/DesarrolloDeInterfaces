import 'dart:math';

import 'package:flutter/material.dart';
import 'package:trabajo_final/widgets/animated_card.dart';

class WidgetFlipper extends StatefulWidget{
  const WidgetFlipper({super.key, required this.frontWidget, required this.backWidget, this.left, this.right, this.top, this.bottom});

  final Widget frontWidget;
  final Widget backWidget;
  final double? left;
  final double? right;
  final double? top;
  final double? bottom;

  @override
  State<StatefulWidget> createState() => WidgetFlipperState();
}

class WidgetFlipperState extends State<WidgetFlipper> with SingleTickerProviderStateMixin{
  late AnimationController controller;
  late Animation<double> frontRotation;
  late Animation<double> backRotation;
  bool isFrontVisible = true;

  @override
  void initState() {
    super.initState();

    controller = AnimationController(duration: Duration(milliseconds: 500), vsync: this);
    updateRotations(true);
  }

  void leftRotation(){
    toggleSide(false);
  }

  void rightRotation(){
    toggleSide(true);
  }

  void toggleSide(bool isRightTap){
    updateRotations(isRightTap);
    if (isFrontVisible){
      controller.forward();
      isFrontVisible = false;
    }else{
      controller.reverse();
      isFrontVisible = true;
    }
  }

  updateRotations(bool isRightTap){
    setState(() {
      bool rotateToLeft = (isFrontVisible && !isRightTap) || !isFrontVisible && isRightTap;
      frontRotation = TweenSequence(
        <TweenSequenceItem<double>>[
          TweenSequenceItem<double>(
              tween: Tween(begin: 0.0, end: rotateToLeft ? (pi / 2) : (-pi / 2))
              .chain(CurveTween(curve: Curves.linear)),
              weight: 50.0),
          TweenSequenceItem<double>(
              tween: ConstantTween<double>(rotateToLeft ? (-pi / 2) : (pi / 2)),
              weight: 50.0)
        ]
      ).animate(controller);
      backRotation = TweenSequence(
          <TweenSequenceItem<double>>[
            TweenSequenceItem<double>(
                tween: ConstantTween<double>(rotateToLeft ? (pi / 2) : (-pi / 2)),
                weight: 50.0),
            TweenSequenceItem<double>(
                tween: Tween(begin: rotateToLeft ? (-pi / 2) : (pi / 2), end: 0.0)
                    .chain(CurveTween(curve: Curves.linear)),
                weight: 50.0)
          ]
      ).animate(controller);
    });
  }

  @override
  void dispose() {
    controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Positioned(
      left: widget.left,
      right: widget.right,
      top: widget.top,
      bottom: widget.bottom,
      child: GestureDetector(
        onTap: isFrontVisible ? leftRotation : rightRotation,
        child: Stack(
          children: [
            AnimatedCard(
                animation: backRotation,
                child: widget.backWidget),
            AnimatedCard(
                animation: frontRotation,
                child: widget.frontWidget)
          ],
        ),
      ),
    );
  }
}