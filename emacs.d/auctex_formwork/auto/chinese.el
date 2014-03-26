(TeX-add-style-hook "chinese"
 (lambda ()
    (LaTeX-add-labels
     "1_1"
     "1_2"
     "1_3"
     "1_4"
     "1_5"
     "1"
     "2"
     "3"
     "4_1"
     "4_2"
     "4_3"
     "4"
     "5"
     "6")
    (TeX-add-symbols
     '("tabincell" 2))
    (TeX-run-style-hooks
     "colortbl"
     "longtable"
     "multirow"
     "fancyhdr"
     "color"
     "hyperref"
     "xeCJK"
     "xltxtra"
     "titlesec"
     "pagestyles"
     "indentafter"
     "indentfirst"
     "amssymb"
     "amsfonts"
     "amsmath"
     "graphicx"
     "listings"
     ""
     "geometry"
     "right=2cm"
     "left=2cm"
     "bottom=3cm"
     "top=3cm"
     "latex2e"
     "art12"
     "article"
     "a4paper"
     "12pt")))

