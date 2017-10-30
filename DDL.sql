/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kecc
 * Created: Sep 3, 2017
 */

/**
Usuario/contrasena
cancion/cancion
*/

CREATE TABLE CANCION(
    id NUMBER,
    titulo VARCHAR(30),
    nombreArtista VARCHAR(30),
    genero VARCHAR(30),
    fechaLanzamiento DATE,
    CONSTRAINT PK_CANCION PRIMARY KEY(id)
);