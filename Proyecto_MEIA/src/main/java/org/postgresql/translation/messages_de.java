/* Automatically generated by GNU msgfmt.  Do not modify!  */
package org.postgresql.translation;
public class messages_de extends java.util.ResourceBundle {
  private static final java.lang.String[] table;
  static {
    java.lang.String[] t = new java.lang.String[794];
    t[0] = "";
    t[1] = "Project-Id-Version: head-de\nReport-Msgid-Bugs-To: \nPO-Revision-Date: 2008-09-12 14:22+0200\nLast-Translator: Andre Bialojahn <ab.spamnews@freenet.de>\nLanguage-Team: Deutsch\nLanguage: \nMIME-Version: 1.0\nContent-Type: text/plain; charset=UTF-8\nContent-Transfer-Encoding: 8bit\nX-Generator: KBabel 1.0.2\nX-Poedit-Language: German\nX-Poedit-Country: GERMANY\n";
    t[4] = "DataSource has been closed.";
    t[5] = "Die Datenquelle wurde geschlossen.";
    t[18] = "Where: {0}";
    t[19] = "Wobei: {0}";
    t[26] = "The connection attempt failed.";
    t[27] = "Der Verbindungsversuch schlug fehl.";
    t[28] = "Currently positioned after the end of the ResultSet.  You cannot call deleteRow() here.";
    t[29] = "Die augenblickliche Position ist hinter dem Ende des ResultSets.  Dort kann ''deleteRow()'' nicht aufgerufen werden.";
    t[36] = "Multiple ResultSets were returned by the query.";
    t[37] = "Die Abfrage ergab mehrere ResultSets.";
    t[50] = "Too many update results were returned.";
    t[51] = "Zu viele Updateergebnisse wurden zurückgegeben.";
    t[58] = "Illegal UTF-8 sequence: initial byte is {0}: {1}";
    t[59] = "Ungültige UTF-8-Sequenz: das erste Byte ist {0}: {1}";
    t[66] = "The column name {0} was not found in this ResultSet.";
    t[67] = "Der Spaltenname {0} wurde in diesem ResultSet nicht gefunden.";
    t[70] = "Fastpath call {0} - No result was returned and we expected an integer.";
    t[71] = "Der Fastpath-Aufruf {0} gab kein Ergebnis zurück, jedoch wurde ein Integer erwartet.";
    t[74] = "Protocol error.  Session setup failed.";
    t[75] = "Protokollfehler.  Die Sitzung konnte nicht gestartet werden.";
    t[76] = "A CallableStatement was declared, but no call to registerOutParameter(1, <some type>) was made.";
    t[77] = "Ein CallableStatement wurde deklariert, aber kein Aufruf von ''registerOutParameter(1, <some type>)'' erfolgte.";
    t[78] = "ResultSets with concurrency CONCUR_READ_ONLY cannot be updated.";
    t[79] = "ResultSets, deren Zugriffsart CONCUR_READ_ONLY ist, können nicht aktualisiert werden.";
    t[90] = "LOB positioning offsets start at 1.";
    t[91] = "Positionsoffsets für LOBs beginnen bei 1.";
    t[92] = "Internal Position: {0}";
    t[93] = "Interne Position: {0}";
    t[96] = "free() was called on this LOB previously";
    t[97] = "free() wurde bereits für dieses LOB aufgerufen.";
    t[100] = "Cannot change transaction read-only property in the middle of a transaction.";
    t[101] = "Die Nur-Lesen-Eigenschaft einer Transaktion kann nicht während der Transaktion verändert werden.";
    t[102] = "The JVM claims not to support the {0} encoding.";
    t[103] = "Die JVM behauptet, die Zeichenkodierung {0} nicht zu unterstützen.";
    t[108] = "{0} function doesn''t take any argument.";
    t[109] = "Die {0}-Funktion akzeptiert kein Argument.";
    t[112] = "xid must not be null";
    t[113] = "Die xid darf nicht null sein.";
    t[114] = "Connection has been closed.";
    t[115] = "Die Verbindung wurde geschlossen.";
    t[122] = "The server does not support SSL.";
    t[123] = "Der Server unterstützt SSL nicht.";
    t[140] = "Illegal UTF-8 sequence: byte {0} of {1} byte sequence is not 10xxxxxx: {2}";
    t[141] = "Ungültige UTF-8-Sequenz: Byte {0} der {1} Bytesequenz ist nicht 10xxxxxx: {2}";
    t[148] = "Hint: {0}";
    t[149] = "Hinweis: {0}";
    t[152] = "Unable to find name datatype in the system catalogs.";
    t[153] = "In den Systemkatalogen konnte der Namensdatentyp nicht gefunden werden.";
    t[156] = "Unsupported Types value: {0}";
    t[157] = "Unbekannter Typ: {0}.";
    t[158] = "Unknown type {0}.";
    t[159] = "Unbekannter Typ {0}.";
    t[166] = "{0} function takes two and only two arguments.";
    t[167] = "Die {0}-Funktion erwartet genau zwei Argumente.";
    t[170] = "Finalizing a Connection that was never closed:";
    t[171] = "Eine Connection wurde finalisiert, die nie geschlossen wurde:";
    t[180] = "The maximum field size must be a value greater than or equal to 0.";
    t[181] = "Die maximale Feldgröße muss ein Wert größer oder gleich Null sein.";
    t[186] = "PostgreSQL LOBs can only index to: {0}";
    t[187] = "LOBs in PostgreSQL können nur auf {0} verweisen.";
    t[194] = "Method {0} is not yet implemented.";
    t[195] = "Die Methode {0} ist noch nicht implementiert.";
    t[198] = "Error loading default settings from driverconfig.properties";
    t[199] = "Fehler beim Laden der Voreinstellungen aus driverconfig.properties";
    t[200] = "Results cannot be retrieved from a CallableStatement before it is executed.";
    t[201] = "Ergebnisse können nicht von einem CallableStatement abgerufen werden, bevor es ausgeführt wurde.";
    t[202] = "Large Objects may not be used in auto-commit mode.";
    t[203] = "LargeObjects (LOB) dürfen im Modus ''auto-commit'' nicht verwendet werden.";
    t[208] = "Expected command status BEGIN, got {0}.";
    t[209] = "Statt des erwarteten Befehlsstatus BEGIN, wurde {0} empfangen.";
    t[218] = "Invalid fetch direction constant: {0}.";
    t[219] = "Unzulässige Richtungskonstante bei fetch: {0}.";
    t[222] = "{0} function takes three and only three arguments.";
    t[223] = "Die {0}-Funktion erwartet genau drei Argumente.";
    t[226] = "Error during recover";
    t[227] = "Beim Wiederherstellen trat ein Fehler auf.";
    t[228] = "Cannot update the ResultSet because it is either before the start or after the end of the results.";
    t[229] = "Das ResultSet kann nicht aktualisiert werden, da es entweder vor oder nach dem Ende der Ergebnisse ist.";
    t[230] = "The JVM claims not to support the encoding: {0}";
    t[231] = "Die JVM behauptet, die Zeichenkodierung {0} nicht zu unterstützen.";
    t[232] = "Parameter of type {0} was registered, but call to get{1} (sqltype={2}) was made.";
    t[233] = "Ein Parameter des Typs {0} wurde registriert, jedoch erfolgte ein Aufruf get{1} (sqltype={2}).";
    t[240] = "Cannot establish a savepoint in auto-commit mode.";
    t[241] = "Ein Rettungspunkt kann im Modus ''auto-commit'' nicht erstellt werden.";
    t[242] = "Cannot retrieve the id of a named savepoint.";
    t[243] = "Die ID eines benamten Rettungspunktes kann nicht ermittelt werden.";
    t[244] = "The column index is out of range: {0}, number of columns: {1}.";
    t[245] = "Der Spaltenindex {0} ist außerhalb des gültigen Bereichs. Anzahl Spalten: {1}.";
    t[250] = "Something unusual has occurred to cause the driver to fail. Please report this exception.";
    t[251] = "Etwas Ungewöhnliches ist passiert, das den Treiber fehlschlagen ließ. Bitte teilen Sie diesen Fehler mit.";
    t[260] = "Cannot cast an instance of {0} to type {1}";
    t[261] = "Die Typwandlung für eine Instanz von {0} nach {1} ist nicht möglich.";
    t[264] = "Unknown Types value.";
    t[265] = "Unbekannter Typ.";
    t[266] = "Invalid stream length {0}.";
    t[267] = "Ungültige Länge des Datenstroms: {0}.";
    t[272] = "Cannot retrieve the name of an unnamed savepoint.";
    t[273] = "Der Name eines namenlosen Rettungpunktes kann nicht ermittelt werden.";
    t[274] = "Unable to translate data into the desired encoding.";
    t[275] = "Die Daten konnten nicht in die gewünschte Kodierung gewandelt werden.";
    t[276] = "Expected an EOF from server, got: {0}";
    t[277] = "Vom Server wurde ein EOF erwartet, jedoch {0} gelesen.";
    t[278] = "Bad value for type {0} : {1}";
    t[279] = "Unzulässiger Wert für den Typ {0} : {1}.";
    t[280] = "The server requested password-based authentication, but no password was provided.";
    t[281] = "Der Server verlangt passwortbasierte Authentifizierung, jedoch wurde kein Passwort angegeben.";
    t[296] = "Truncation of large objects is only implemented in 8.3 and later servers.";
    t[297] = "Das Abschneiden großer Objekte ist nur in Versionen nach 8.3 implementiert.";
    t[298] = "This PooledConnection has already been closed.";
    t[299] = "Diese PooledConnection ist bereits geschlossen worden.";
    t[302] = "ClientInfo property not supported.";
    t[303] = "Die ClientInfo-Eigenschaft ist nicht unterstützt.";
    t[306] = "Fetch size must be a value greater to or equal to 0.";
    t[307] = "Die Fetch-Größe muss ein Wert größer oder gleich Null sein.";
    t[312] = "A connection could not be made using the requested protocol {0}.";
    t[313] = "Es konnte keine Verbindung unter Verwendung des Protokolls {0} hergestellt werden.";
    t[322] = "There are no rows in this ResultSet.";
    t[323] = "Es gibt keine Zeilen in diesem ResultSet.";
    t[324] = "Unexpected command status: {0}.";
    t[325] = "Unerwarteter Befehlsstatus: {0}.";
    t[334] = "Not on the insert row.";
    t[335] = "Nicht in der Einfügezeile.";
    t[344] = "Server SQLState: {0}";
    t[345] = "Server SQLState: {0}";
    t[348] = "The server''s standard_conforming_strings parameter was reported as {0}. The JDBC driver expected on or off.";
    t[349] = "Der standard_conforming_strings Parameter des Servers steht auf {0}. Der JDBC-Treiber erwartete on oder off.";
    t[360] = "The driver currently does not support COPY operations.";
    t[361] = "Der Treiber unterstützt derzeit keine COPY-Operationen.";
    t[364] = "The array index is out of range: {0}, number of elements: {1}.";
    t[365] = "Der Arrayindex {0} ist außerhalb des gültigen Bereichs. Vorhandene Elemente: {1}.";
    t[374] = "suspend/resume not implemented";
    t[375] = "Anhalten/Fortsetzen ist nicht implementiert.";
    t[378] = "Not implemented: one-phase commit must be issued using the same connection that was used to start it";
    t[379] = "Nicht implementiert: Die einphasige Bestätigung muss über die selbe Verbindung abgewickelt werden, die verwendet wurde, um sie zu beginnen.";
    t[398] = "Cannot call cancelRowUpdates() when on the insert row.";
    t[399] = "''cancelRowUpdates()'' kann in der Einfügezeile nicht aufgerufen werden.";
    t[400] = "Cannot reference a savepoint after it has been released.";
    t[401] = "Ein Rettungspunkt kann nicht angesprochen werden, nach dem er entfernt wurde.";
    t[402] = "You must specify at least one column value to insert a row.";
    t[403] = "Sie müssen mindestens einen Spaltenwert angeben, um eine Zeile einzufügen.";
    t[404] = "Unable to determine a value for MaxIndexKeys due to missing system catalog data.";
    t[405] = "Es konnte kein Wert für MaxIndexKeys gefunden werden, da die Systemkatalogdaten fehlen.";
    t[412] = "Illegal UTF-8 sequence: final value is out of range: {0}";
    t[413] = "Ungültige UTF-8-Sequenz: Der letzte Wert ist außerhalb des zulässigen Bereichs: {0}";
    t[414] = "{0} function takes two or three arguments.";
    t[415] = "Die {0}-Funktion erwartet zwei oder drei Argumente.";
    t[440] = "Unexpected error writing large object to database.";
    t[441] = "Beim Schreiben eines LargeObjects (LOB) in die Datenbank trat ein unerwarteter Fehler auf.";
    t[442] = "Zero bytes may not occur in string parameters.";
    t[443] = "Stringparameter dürfen keine Nullbytes enthalten.";
    t[444] = "A result was returned when none was expected.";
    t[445] = "Die Anweisung lieferte ein Ergebnis obwohl keines erwartet wurde.";
    t[450] = "ResultSet is not updateable.  The query that generated this result set must select only one table, and must select all primary keys from that table. See the JDBC 2.1 API Specification, section 5.6 for more details.";
    t[451] = "Das ResultSet kann nicht aktualisiert werden.  Die Abfrage, die es erzeugte, darf nur eine Tabelle und muss darin alle Primärschlüssel auswählen. Siehe JDBC 2.1 API-Spezifikation, Abschnitt 5.6 für mehr Details.";
    t[454] = "Bind message length {0} too long.  This can be caused by very large or incorrect length specifications on InputStream parameters.";
    t[455] = "Die Nachrichtenlänge {0} ist zu groß. Das kann von sehr großen oder inkorrekten Längenangaben eines InputStream-Parameters herrühren.";
    t[460] = "Statement has been closed.";
    t[461] = "Die Anweisung wurde geschlossen.";
    t[462] = "No value specified for parameter {0}.";
    t[463] = "Für den Parameter {0} wurde kein Wert angegeben.";
    t[468] = "The array index is out of range: {0}";
    t[469] = "Der Arrayindex ist außerhalb des gültigen Bereichs: {0}.";
    t[474] = "Unable to bind parameter values for statement.";
    t[475] = "Der Anweisung konnten keine Parameterwerte zugewiesen werden.";
    t[476] = "Can''t refresh the insert row.";
    t[477] = "Die Einfügezeile kann nicht aufgefrischt werden.";
    t[480] = "No primary key found for table {0}.";
    t[481] = "Für die Tabelle {0} konnte kein Primärschlüssel gefunden werden.";
    t[482] = "Cannot change transaction isolation level in the middle of a transaction.";
    t[483] = "Die Transaktions-Trennungsstufe kann nicht während einer Transaktion verändert werden.";
    t[498] = "Provided InputStream failed.";
    t[499] = "Der bereitgestellte InputStream scheiterte.";
    t[500] = "The parameter index is out of range: {0}, number of parameters: {1}.";
    t[501] = "Der Parameterindex {0} ist außerhalb des gültigen Bereichs. Es gibt {1} Parameter.";
    t[502] = "The server''s DateStyle parameter was changed to {0}. The JDBC driver requires DateStyle to begin with ISO for correct operation.";
    t[503] = "Der Parameter ''Date Style'' wurde auf dem Server auf {0} verändert. Der JDBC-Treiber setzt für korrekte Funktion voraus, dass ''Date Style'' mit ''ISO'' beginnt.";
    t[508] = "Connection attempt timed out.";
    t[509] = "Keine Verbindung innerhalb des Zeitintervalls möglich.";
    t[512] = "Internal Query: {0}";
    t[513] = "Interne Abfrage: {0}";
    t[518] = "The authentication type {0} is not supported. Check that you have configured the pg_hba.conf file to include the client''s IP address or subnet, and that it is using an authentication scheme supported by the driver.";
    t[519] = "Der Authentifizierungstyp {0} wird nicht unterstützt. Stellen Sie sicher, dass die Datei ''pg_hba.conf'' die IP-Adresse oder das Subnetz des Clients enthält und dass der Client ein Authentifizierungsschema nutzt, das vom Treiber unterstützt wird.";
    t[526] = "Interval {0} not yet implemented";
    t[527] = "Intervall {0} ist noch nicht implementiert.";
    t[532] = "Conversion of interval failed";
    t[533] = "Die Umwandlung eines Intervalls schlug fehl.";
    t[540] = "Query timeout must be a value greater than or equals to 0.";
    t[541] = "Das Abfragetimeout muss ein Wert größer oder gleich Null sein.";
    t[542] = "Connection has been closed automatically because a new connection was opened for the same PooledConnection or the PooledConnection has been closed.";
    t[543] = "Die Verbindung wurde automatisch geschlossen, da entweder eine neue Verbindung für die gleiche PooledConnection geöffnet wurde, oder die PooledConnection geschlossen worden ist..";
    t[544] = "ResultSet not positioned properly, perhaps you need to call next.";
    t[545] = "Das ResultSet ist nicht richtig positioniert. Eventuell muss ''next'' aufgerufen werden.";
    t[550] = "This statement has been closed.";
    t[551] = "Die Anweisung wurde geschlossen.";
    t[552] = "Can''t infer the SQL type to use for an instance of {0}. Use setObject() with an explicit Types value to specify the type to use.";
    t[553] = "Der in SQL für eine Instanz von {0} zu verwendende Datentyp kann nicht abgeleitet werden. Benutzen Sie ''setObject()'' mit einem expliziten Typ, um ihn festzulegen.";
    t[554] = "Cannot call updateRow() when on the insert row.";
    t[555] = "''updateRow()'' kann in der Einfügezeile nicht aufgerufen werden.";
    t[562] = "Detail: {0}";
    t[563] = "Detail: {0}";
    t[566] = "Cannot call deleteRow() when on the insert row.";
    t[567] = "''deleteRow()'' kann in der Einfügezeile nicht aufgerufen werden.";
    t[568] = "Currently positioned before the start of the ResultSet.  You cannot call deleteRow() here.";
    t[569] = "Die augenblickliche Position ist vor dem Beginn des ResultSets.  Dort kann ''deleteRow()'' nicht aufgerufen werden.";
    t[576] = "Illegal UTF-8 sequence: final value is a surrogate value: {0}";
    t[577] = "Ungültige UTF-8-Sequenz: der letzte Wert ist ein Ersatzwert: {0}";
    t[578] = "Unknown Response Type {0}.";
    t[579] = "Die Antwort weist einen unbekannten Typ auf: {0}.";
    t[582] = "Unsupported value for stringtype parameter: {0}";
    t[583] = "Nichtunterstützter Wert für den Stringparameter: {0}";
    t[584] = "Conversion to type {0} failed: {1}.";
    t[585] = "Die Umwandlung in den Typ {0} schlug fehl: {1}.";
    t[586] = "Conversion of money failed.";
    t[587] = "Die Umwandlung eines Währungsbetrags schlug fehl.";
    t[600] = "Unable to load the class {0} responsible for the datatype {1}";
    t[601] = "Die für den Datentyp {1} verantwortliche Klasse {0} konnte nicht geladen werden.";
    t[604] = "The fastpath function {0} is unknown.";
    t[605] = "Die Fastpath-Funktion {0} ist unbekannt.";
    t[608] = "Malformed function or procedure escape syntax at offset {0}.";
    t[609] = "Unzulässige Syntax für ein Funktions- oder Prozedur-Escape an Offset {0}.";
    t[612] = "Provided Reader failed.";
    t[613] = "Der bereitgestellte Reader scheiterte.";
    t[614] = "Maximum number of rows must be a value grater than or equal to 0.";
    t[615] = "Die maximale Zeilenzahl muss ein Wert größer oder gleich Null sein.";
    t[616] = "Failed to create object for: {0}.";
    t[617] = "Erstellung des Objektes schlug fehl für: {0}.";
    t[622] = "Premature end of input stream, expected {0} bytes, but only read {1}.";
    t[623] = "Vorzeitiges Ende des Eingabedatenstroms. Es wurden {0} Bytes erwartet, jedoch nur {1} gelesen.";
    t[626] = "An unexpected result was returned by a query.";
    t[627] = "Eine Abfrage lieferte ein unerwartetes Resultat.";
    t[646] = "An error occurred while setting up the SSL connection.";
    t[647] = "Beim Aufbau der SSL-Verbindung trat ein Fehler auf.";
    t[654] = "Illegal UTF-8 sequence: {0} bytes used to encode a {1} byte value: {2}";
    t[655] = "Ungültige UTF-8-Sequenz: {0} Bytes wurden verwendet um einen {1} Bytewert zu kodieren: {2}";
    t[658] = "The SSLSocketFactory class provided {0} could not be instantiated.";
    t[659] = "Die von {0} bereitgestellte SSLSocketFactory-Klasse konnte nicht instanziiert werden.";
    t[670] = "Position: {0}";
    t[671] = "Position: {0}";
    t[676] = "Location: File: {0}, Routine: {1}, Line: {2}";
    t[677] = "Ort: Datei: {0}, Routine: {1}, Zeile: {2}.";
    t[684] = "Cannot tell if path is open or closed: {0}.";
    t[685] = "Es konnte nicht ermittelt werden, ob der Pfad offen oder geschlossen ist: {0}.";
    t[700] = "Cannot convert an instance of {0} to type {1}";
    t[701] = "Die Typwandlung für eine Instanz von {0} nach {1} ist nicht möglich.";
    t[710] = "{0} function takes four and only four argument.";
    t[711] = "Die {0}-Funktion erwartet genau vier Argumente.";
    t[718] = "Interrupted while attempting to connect.";
    t[719] = "Beim Verbindungsversuch trat eine Unterbrechung auf.";
    t[722] = "Your security policy has prevented the connection from being attempted.  You probably need to grant the connect java.net.SocketPermission to the database server host and port that you wish to connect to.";
    t[723] = "Ihre Sicherheitsrichtlinie hat den Versuch des Verbindungsaufbaus verhindert. Sie müssen wahrscheinlich der Verbindung zum Datenbankrechner java.net.SocketPermission gewähren, um den Rechner auf dem gewählten Port zu erreichen.";
    t[728] = "Failed to initialize LargeObject API";
    t[729] = "Die LargeObject-API konnte nicht initialisiert werden.";
    t[736] = "{0} function takes one and only one argument.";
    t[737] = "Die {0}-Funktion erwartet nur genau ein Argument.";
    t[744] = "This ResultSet is closed.";
    t[745] = "Dieses ResultSet ist geschlossen.";
    t[746] = "Invalid character data was found.  This is most likely caused by stored data containing characters that are invalid for the character set the database was created in.  The most common example of this is storing 8bit data in a SQL_ASCII database.";
    t[747] = "Ungültige Zeichendaten.  Das ist höchstwahrscheinlich von in der Datenbank gespeicherten Zeichen hervorgerufen, die in einer anderen Kodierung vorliegen, als die, in der die Datenbank erstellt wurde.  Das häufigste Beispiel dafür ist es, 8Bit-Daten in SQL_ASCII-Datenbanken abzulegen.";
    t[752] = "Error disabling autocommit";
    t[753] = "Fehler beim Abschalten von Autocommit.";
    t[754] = "Ran out of memory retrieving query results.";
    t[755] = "Nicht genügend Speicher beim Abholen der Abfrageergebnisse.";
    t[756] = "Returning autogenerated keys is not supported.";
    t[757] = "Die Rückgabe automatisch generierter Schlüssel wird nicht unterstützt,";
    t[760] = "Operation requires a scrollable ResultSet, but this ResultSet is FORWARD_ONLY.";
    t[761] = "Die Operation erfordert ein scrollbares ResultSet, dieses jedoch ist FORWARD_ONLY.";
    t[762] = "A CallableStatement function was executed and the out parameter {0} was of type {1} however type {2} was registered.";
    t[763] = "Eine CallableStatement-Funktion wurde ausgeführt und der Rückgabewert {0} war vom Typ {1}. Jedoch wurde der Typ {2} dafür registriert.";
    t[768] = "Unknown ResultSet holdability setting: {0}.";
    t[769] = "Unbekannte Einstellung für die Haltbarkeit des ResultSets: {0}.";
    t[772] = "Transaction isolation level {0} not supported.";
    t[773] = "Die Transaktions-Trennungsstufe {0} ist nicht unterstützt.";
    t[774] = "Zero bytes may not occur in identifiers.";
    t[775] = "Nullbytes dürfen in Bezeichnern nicht vorkommen.";
    t[776] = "No results were returned by the query.";
    t[777] = "Die Abfrage lieferte kein Ergebnis.";
    t[778] = "A CallableStatement was executed with nothing returned.";
    t[779] = "Ein CallableStatement wurde ausgeführt ohne etwas zurückzugeben.";
    t[780] = "wasNull cannot be call before fetching a result.";
    t[781] = "wasNull kann nicht aufgerufen werden, bevor ein Ergebnis abgefragt wurde.";
    t[786] = "This statement does not declare an OUT parameter.  Use '{' ?= call ... '}' to declare one.";
    t[787] = "Diese Anweisung deklariert keinen OUT-Parameter. Benutzen Sie '{' ?= call ... '}' um das zu tun.";
    t[788] = "Can''t use relative move methods while on the insert row.";
    t[789] = "Relative Bewegungen können in der Einfügezeile nicht durchgeführt werden.";
    t[790] = "A CallableStatement was executed with an invalid number of parameters";
    t[791] = "Ein CallableStatement wurde mit einer falschen Anzahl Parameter ausgeführt.";
    t[792] = "Connection is busy with another transaction";
    t[793] = "Die Verbindung ist derzeit mit einer anderen Transaktion beschäftigt.";
    table = t;
  }
  public java.lang.Object handleGetObject (java.lang.String msgid) throws java.util.MissingResourceException {
    int hash_val = msgid.hashCode() & 0x7fffffff;
    int idx = (hash_val % 397) << 1;
    {
      java.lang.Object found = table[idx];
      if (found == null)
        return null;
      if (msgid.equals(found))
        return table[idx + 1];
    }
    int incr = ((hash_val % 395) + 1) << 1;
    for (;;) {
      idx += incr;
      if (idx >= 794)
        idx -= 794;
      java.lang.Object found = table[idx];
      if (found == null)
        return null;
      if (msgid.equals(found))
        return table[idx + 1];
    }
  }
  public java.util.Enumeration getKeys () {
    return
      new java.util.Enumeration() {
        private int idx = 0;
        { while (idx < 794 && table[idx] == null) idx += 2; }
        public boolean hasMoreElements () {
          return (idx < 794);
        }
        public java.lang.Object nextElement () {
          java.lang.Object key = table[idx];
          do idx += 2; while (idx < 794 && table[idx] == null);
          return key;
        }
      };
  }
  public java.util.ResourceBundle getParent () {
    return parent;
  }
}
