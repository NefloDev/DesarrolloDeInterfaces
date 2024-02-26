import 'package:animated_widgets/animated_widgets.dart';
import 'package:flutter/cupertino.dart';

class FlippedCard extends StatefulWidget{
  const FlippedCard({super.key, required this.frontWidget, required this.backWidget});

  final Widget frontWidget;
  final Widget backWidget;

  @override
  State<StatefulWidget> createState() => FlippedCardState();
}

class FlippedCardState extends State<FlippedCard>{

  late Widget currentWidget;
  late bool isFrontVisible;
  late bool animate;
  late bool animate2;
  late double startRotation;
  late double endRotation;

  @override
  void initState() {
    super.initState();
    currentWidget = widget.frontWidget;
    isFrontVisible = true;
    animate = false;
    animate2 = false;
    startRotation = 0;
    endRotation = 90;
  }

  void switchWidget(){
    if (isFrontVisible){
      currentWidget = widget.backWidget;
      isFrontVisible = false;
    }else{
      currentWidget = widget.frontWidget;
      isFrontVisible = true;
    }
  }

  @override
  Widget build(BuildContext context) {
    return RotationAnimatedWidget.tween(
        enabled: animate,
        curve: Curves.bounceOut,
        rotationDisabled: Rotation.deg(y: startRotation),
        rotationEnabled: Rotation.deg(y: endRotation),
        child: GestureDetector(
          child: currentWidget,
          onTap: () async {
            setState(() {
              startRotation = 0;
              endRotation = 90;
              animate = true;
            });
            await Future.delayed(Duration(milliseconds: 400), (){
              switchWidget();
            }).then((value){
              setState(() {
                startRotation = 90;
                endRotation = 0;
                animate = false;
              });
            });
            setState(() {
              animate = true;
            });
          },
        )
    );
  }

}