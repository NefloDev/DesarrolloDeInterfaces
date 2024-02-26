import "package:flutter/material.dart";
import "package:trabajo_final/constants/custom-colors.dart";
import "package:trabajo_final/models/user.dart";
import "package:trabajo_final/widgets/custom_icon_button.dart";
import "package:trabajo_final/widgets/custom_menu_button.dart";
import "package:trabajo_final/widgets/custom_shaped_box.dart";
import "package:trabajo_final/widgets/diagonal_box.dart";

class WaitingRoomScreen extends StatefulWidget {
  const WaitingRoomScreen({super.key});

  @override
  State<StatefulWidget> createState() => WaitingRoomScreenState();
}

class WaitingRoomScreenState extends State<WaitingRoomScreen>{

  List<User> users = [
    User("Player 1"),
    User("Player 2"),
    User("Player 3"),
    User("Player 4"),
    User("Player 5"),
    User("Player 6"),
    User("Player 7"),
    User("Player 8"),
    User("Player 9"),
    User("Player 10"),
    User("Player 11"),
    User("Player 12"),
    User("Player 13"),
    User("Player 14")
  ];

  List<Widget> _getUserList(){
    List<Widget> playerList = [];
    for(int i = 0; i< users.length; i++){
      playerList.add(
        Padding(
          padding: const EdgeInsets.only(bottom: 15),
          child: CustomShapedBox(
              radius: BorderRadius.all(Radius.circular(50)),
              height: 50,
              width: 350,
              color: CustomColors.alternateColors[i],
              alignment: Alignment.center,
              child: Text(users[i].name.toUpperCase(),
                style: const TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 22
                ),
              ),
          ),
        )
      );
    }
    return playerList;
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Stack(
            children: [
              DiagonalBox(
                angle: -10,
                top: -100,
                height: 350,
                width: (MediaQuery.of(context).size.width + 100),
                color: CustomColors.bgLight,
                shadow: false,
              ),
              const DiagonalBox(
                alignment: Alignment.centerLeft,
                padding: 0,
                top: 120,
                left: 40,
                angle: 8,
                height: 80,
                width: 250,
                color: CustomColors.mainOrange,
                child: Padding(
                  padding: EdgeInsets.only(left: 20),
                  child: Text("Código de\npartida",
                    textAlign: TextAlign.center,
                    style: TextStyle(
                        color: CustomColors.bgBlue
                    ),
                  ),
                ),
              ),
              Positioned(
                top: 280,
                left: 0,
                right: 0,
                bottom: 0,
                child: SingleChildScrollView(
                  child: Column(
                    children: _getUserList(),
                  ),
                ),
              ),
              const CustomMenuButton(
                  top: 50,
                  right: -110,
                  height: 50,
                  width: 200,
                  buttonColor: CustomColors.mainFuchsia,
                  text: Text("Cartas",
                      style: TextStyle(
                          fontSize: 16
                      )
                  ),
                  alignment: Alignment.centerLeft
              ),
              Positioned(
                  top: 220,
                  left: 20,
                  child: Text("${users.length}/14 Jugadores en la sala:",
                      style: const TextStyle(
                          color: Colors.white,
                          fontSize: 24
                      )
                  )
              ),
              CustomIconButton(
                  top: 100,
                  left: 20,
                  angle: 0,
                  buttonSize: 40,
                  color: Colors.white,
                  icon: const Icon(
                      Icons.arrow_back,
                      color: CustomColors.bgLight,
                      size: 20),
                  onPressed: (){
                    Navigator.pop(context);
                  }
              )
            ]
        )
    );
  }
}
