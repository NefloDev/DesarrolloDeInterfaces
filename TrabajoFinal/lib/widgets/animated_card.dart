import 'package:flutter/cupertino.dart';

class AnimatedCard extends StatelessWidget{
  const AnimatedCard({super.key, required this.animation, required this.child});

  final Animation<double> animation;
  final Widget child;

  @override
  Widget build(BuildContext context) {
    return AnimatedBuilder(
      animation: animation,
      builder: (BuildContext context, Widget? child){
        var transform = Matrix4.identity();
        transform.rotateY(animation.value);
        return Transform(
            transform: transform,
            alignment: Alignment.center,
            child: child
        );
        },
      child: child,
    );
  }

}