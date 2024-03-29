package org.example

import com.jayway.jsonpath.DocumentContext
import com.jayway.jsonpath.JsonPath
import com.jayway.jsonpath.Predicate

/*
 * Author: Eric.chen$
 * Created: 2024/3/29$
 * Last modified: 2024/3/29$
 * Description: 
 */
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    var message = "{\"gatewayId\":\"mqtt.c1209830320910331904\",\"msgType\":\"report\",\"namespace\":\"10000210\",\"payload\":[{\"data\":{\"0.12.85\":5520},\"did\":\"mqtt.c1209830336887947264\",\"time\":1711713042852}],\"random\":\"123\",\"seq\":41782,\"timeStamp\":1711713042852}";



    // it can not work
//    var query  = "\$['payload'][?(@.did == 'mqtt.c1209830336887947264')].[0]['data']['0.12.85']"
    var query  = "\$['payload'][?(@.did == 'mqtt.c1209830336887947264')]"

    var type = Any::class.java
    val jsonContext: DocumentContext = JsonPath.parse(message)
    var x =  jsonContext.read(query, type, *arrayOfNulls<Predicate>(0))

    println(x)
    var query1  = "\$.[0].data['0.12.85']"

    val jsonContext1: DocumentContext = JsonPath.parse(x.toString())
    var x2 =  jsonContext1.read(query1, type, *arrayOfNulls<Predicate>(0))
    println(x2)



}