import 'package:flutter/material.dart';
import 'package:trabajo_final/constants/custom_colors.dart';
import 'package:trabajo_final/screens/main_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Quien crees que...',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
            colorScheme: ColorScheme.fromSeed(
                seedColor: Colors.deepPurple,
                background: CustomColors.bgBlue
            ),
            useMaterial3: true,
            fontFamily: "Gotham",
        ),
        home: const MainScreen());
  }
}
