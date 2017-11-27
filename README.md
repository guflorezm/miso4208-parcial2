# miso4208-parcial2
Parte practica parcial 2 MISO-4208

## Reporte Mutantes

En Windows se compila la aplicación original antes de ejecutarle MDroid+ y se genera la app correctamente, se puede observar en el siguiente video

![gunucash-antes](https://github.com/guflorezm/miso4208-parcial2/blob/master/reporte-errores/compilacion_gnucash_before_mdroid.gif)

Luego se le ejecuta MDroid+ y se compila luego y no genera la app por errores de compilacion, al parecer los archivos fuentes quedan con algun tipo error de formateo de edición desúes de ejecutada MDroid+, como se puede observar en el siguiente video

![gunucash-despues](https://github.com/guflorezm/miso4208-parcial2/blob/master/reporte-errores/error_compilacion_gnucash_after_mdroid.gif)

Luego se monta la aplicación original nuevamente y solo se reemplaza el archivo generado por el mutante 674 pero igualmente genera errores de compilación como se observa en el siguiente video

![gunucash-antes](https://github.com/guflorezm/miso4208-parcial2/blob/master/reporte-errores/my-mutant674-test-error.gif)

Los unicos mutantes que no generaban error de compilación fueron los de tipo WrongStringResource

Por lo que Mario decidió que solo trabajara mutantes de este tipo y los mutantes seleccionados fueron:

* mutant163
* mutant164
* mutant170
* mutant179
* mutant180
* mutant183
* mutant190
* mutant224
* mutant425
* mutant429

El log de los mutantes generados se puede encontrar en el siguiente enlace:
https://github.com/guflorezm/miso4208-parcial2/blob/master/gnucash-mutants.log

Para cada mutante hay una carpeta en este repositorio que contiene videos de las pruebas ejcutadas, el APK generado y el archivo de la prueba en espresso 

## Mutante 163

Para este mutante se crea una prueba que cree una cuenta, en este caso se hace desde el wizard de setup inicial, por lo que para ejecutarla se debe montar la aplicación desde cero

A continuación se puede ver un video de la prueba antes del mutante

![mutant163-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant163/my-mutant163-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant163-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant163/my-mutant163-test-error.gif)

## Mutante 164

Para este mutante se crea una prueba que edite una cuenta ya creada

A continuación se puede ver un video de la prueba antes del mutante

![mutant164-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant164/my-mutant164-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant164-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant164/my-mutant164-test-error.gif)

## Mutante 170

Para este mutante se crea una prueba que cree una cuenta y la busque inmediatamente

A continuación se puede ver un video de la prueba antes del mutante

![mutant170-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant170/my-mutant170-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant170-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant170/my-mutant170-test-error.gif)

## Mutante 179

Para este mutante se crea una prueba que cree una transacción

A continuación se puede ver un video de la prueba antes del mutante

![mutant179-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant179/my-mutant179-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant179-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant179/my-mutant179-test-error.gif)

## Mutante 180

Para este mutante se crea una prueba que visualice cuando no existen transacciones para una cuenta

A continuación se puede ver un video de la prueba antes del mutante

![mutant180-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant180/my-mutant180-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant180-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant180/my-mutant180-test-error.gif)

## Mutante 183

Para este mutante se crea una prueba que busque una cuenta creada

A continuación se puede ver un video de la prueba antes del mutante

![mutant183-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant183/my-mutant183-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant183-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant183/my-mutant183-test-error.gif)

## Mutante 190

Para este mutante se crea una prueba que edite una transacción creada para una cuenta

A continuación se puede ver un video de la prueba antes del mutante

![mutant190-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant190/my-mutant190-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant190-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant190/my-mutant190-test-error.gif)

## Mutante 224

Para este mutante se crea una prueba que visualice la opción de preferencias generales del menu de ajustes 

A continuación se puede ver un video de la prueba antes del mutante

![mutant224-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant224/my-mutant224-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant224-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant224/my-mutant224-test-error.gif)

## Mutante 425

Para este mutante se crea una prueba que visualice el reporte de la hoja de balance 

A continuación se puede ver un video de la prueba antes del mutante

![mutant425-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant425/my-mutant425-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant425-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant425/my-mutant425-test-error.gif)

## Mutante 429

Para este mutante se crea una prueba que visualice el valor neto del reporte de la hoja de balance 

A continuación se puede ver un video de la prueba antes del mutante

![mutant429-ok](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant429/my-mutant429-test-ok.gif)

A continuación se puede ver un video de la prueba despues del mutante asesinado

![mutant429-error](https://github.com/guflorezm/miso4208-parcial2/blob/master/mutant429/my-mutant429-test-error.gif)



















