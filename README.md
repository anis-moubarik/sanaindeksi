sanaindeksi
===========

Trie-puulla toteutettava sanaindeksi, ohjelma voi hakea tiedostosta hakusanalla rivit
miss� sanat esiintyv�t.
Ohjelma k�ytt�� trie-puutta, jossa lapsisolmut on tallennettu dynaamiseen j�rjestettyyn
tauluun (aluksi k�ytt�m�ll� javan ArrayListi�). Alustavasti ohjelmaa on tarkoitus k�ytt�� komentorivilt�,
eli ohjelmalle annettaan joko k�ynnistysparametreissa tai itse ohjelmasta, esim. "lataa" komennolla.


Toteutusymp�rist�
-------------------------------
Toteutan harjoitysty�n NetBeansissa, projektihallinnassa auttaa Maven sek� cloudbeesin jenkins palvelin.
Testauksessa k�yt�n JUnittia, ja versionhallinnassa Gitti� sek� GitHubia.

Toimintaymp�rist�
------------------------------
Ohjelma toimii kaikissa koneissa joihin on asennettu uusin Java.

Ongelmakohtia
-------------------------
Tehokas tietorakenne Trie-puun lapsien s�il�miseen.
Mit� tietoa sanasta tallennetaan TrieSolmuun.
