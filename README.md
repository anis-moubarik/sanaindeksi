sanaindeksi
===========

Trie-puulla toteutettava sanaindeksi, ohjelma voi hakea tiedostosta hakusanalla rivit
missä sanat esiintyvät.
Ohjelma käyttää trie-puutta, jossa lapsisolmut on tallennettu dynaamiseen järjestettyyn
tauluun (aluksi käyttämällä javan ArrayListiä). Alustavasti ohjelmaa on tarkoitus käyttää komentoriviltä,
eli ohjelmalle annettaan joko käynnistysparametreissa tai itse ohjelmasta, esim. "lataa" komennolla.


Toteutusympäristö
-------------------------------
Toteutan harjoitystyön NetBeansissa, projektihallinnassa auttaa Maven sekä cloudbeesin jenkins palvelin.
Testauksessa käytän JUnittia, ja versionhallinnassa Gittiä sekä GitHubia.

Toimintaympäristö
------------------------------
Ohjelma toimii kaikissa koneissa joihin on asennettu uusin Java.

Ongelmakohtia
-------------------------
Tehokas tietorakenne Trie-puun lapsien säilömiseen.
Mitä tietoa sanasta tallennetaan TrieSolmuun.
