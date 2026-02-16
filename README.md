# Sen - Textová adventura

Sen je textová adventura v Javě, ve které hraješ za hrdinu na výpravě za záchranou princezny. Procházej různými lokacemi, bojuj s nepřáteli a dělej rozhodnutí, která ovlivní tvůj osud.

## Funkce

- Pohyb se mezi různými lokacemi jako „Paseka“, „Sídlo Kronose“ a „Pekelné údolí“.
- Soubojový systém
- Sbírání předmětů
- Herní obsah (předměty, postavy, lokace) se načítá z JSON souboru.
- Easter Egg

## Ovládání

Hra se ovládá jednopísmennými příkazy zadávanými do konzole:

- `w` - Pohyb nahoru (sever)
- `a` - Pohyb doleva (západ)
- `s` - Pohyb dolů (jih)
- `d` - Pohyb doprava (východ)
- `i` - Otevřít inventář
- `e` - Sebrat předměty
- `q` - Začít dialog
- `h` - Nápověda (výpis příkazů)
- `l` - Ukončit hru

## Použité technologie

- Java: Hlavní programovací jazyk.
- Gson: Knihovna Google pro práci s JSON.
- Návrhový vzor Command: Čisté zpracování hráčských vstupů.
