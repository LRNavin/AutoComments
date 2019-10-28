% Copyright (c) 2013 Joost van Zwieten
%
% Permission is hereby granted, free of charge, to any person obtaining a copy
% of this software and associated documentation files (the "Software"), to deal
% in the Software without restriction, including without limitation the rights
% to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
% copies of the Software, and to permit persons to whom the Software is
% furnished to do so, subject to the following conditions:
%
% The above copyright notice and this permission notice shall be included in
% all copies or substantial portions of the Software.
%
% THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
% IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
% FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
% AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
% LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
% OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
% THE SOFTWARE.
%
\ProvidesClass{tudelftposter}[2013/09/09, v. 1.0]
\NeedsTeXFormat{LaTeX2e}[1995/06/01]
\RequirePackage{etoolbox}

% options [[[

\RequirePackage{kvoptions}
\SetupKeyvalOptions{family=tudelftposter,prefix=tud@opt@}

\DeclareVoidOption{draft}{\PassOptionsToClass{draft}{article}}
\DeclareVoidOption{final}{\PassOptionsToClass{final}{article}}
\DeclareStringOption[]{ncolumns}
\DeclareStringOption[]{footerheight}
\DeclareBoolOption{landscape}
\DeclareBoolOption{experimentalheadergradient}

\ExecuteOptions{final}
\ProcessKeyvalOptions*

\ifx\tud@opt@ncolumns\@empty%
  \def\tud@opt@ncolumns{\iftud@opt@landscape 3\else 2\fi}%
\fi

\iftud@opt@landscape%
  \PassOptionsToPackage{landscape}{geometry}%
\fi

% ]]]

\LoadClass[onecolumn]{article}
\setlength{\columnsep}{3cm}
\newlength{\tud@hmargin}
\setlength{\tud@hmargin}{\columnsep}

% packages [[[

\RequirePackage[paper=a0paper,hmargin=\tud@hmargin,vmargin={0cm,0cm},footskip=\columnsep]{geometry}
\RequirePackage{xcolor}
\RequirePackage{graphicx}
\RequirePackage{tikz}
\usetikzlibrary{calc}
\usetikzlibrary{fadings}
\RequirePackage{multicol}
\RequirePackage{caption}
\RequirePackage{qrcode}

% ]]]

% color definitions [[[

\definecolor{tudcyan}{HTML}{00a6d6}
\colorlet{tud@backgroundcolor}{white}
\let\tud@orig@pagecolor\pagecolor
\def\pagecolor#1{%
  \colorlet{tud@backgroundcolor}{#1}%
  \tud@orig@pagecolor{#1}}

% ]]]
% font size definitions (TODO: should be placed in sizeXXposter.clo files ...) [[[

\RequirePackage{lmodern}
\RequirePackage[T1]{fontenc}
\RequirePackage{textcomp}

% Fix small math symbols.
% source: http://tex.stackexchange.com/questions/74623/big-integral-in-lmodern
% TODO: Is there a better way to fix this?
\DeclareFontFamily{OMX}{lmex}{}
\DeclareFontShape{OMX}{lmex}{m}{n}{<-> lmex10}{}

\rmfamily

%% size 24.88pt
%\renewcommand{\tiny}{\fontsize{12}{14}\selectfont}
%\renewcommand{\scriptsize}{\fontsize{14.4}{18}\selectfont}
%\renewcommand{\footnotesize}{\fontsize{17.28}{22}\selectfont}
%\renewcommand{\small}{\fontsize{20.74}{25}\selectfont}
%\renewcommand{\normalsize}{\fontsize{24.88}{30}\selectfont}
%\renewcommand{\large}{\fontsize{29.86}{37}\selectfont}
%\renewcommand{\Large}{\fontsize{35.83}{45}\selectfont}
%\renewcommand{\LARGE}{\fontsize{43}{54}\selectfont}
%\renewcommand{\huge}{\fontsize{51.6}{64}\selectfont}
%\renewcommand{\Huge}{\fontsize{61.92}{77}\selectfont}
%\newcommand{\veryHuge}{\fontsize{74.3}{93}\selectfont}
%\newcommand{\VeryHuge}{\fontsize{89.16}{112}\selectfont}
%\newcommand{\VERYHuge}{\fontsize{107}{134}\selectfont}

% size 43pt
\renewcommand{\tiny}{\fontsize{20.74}{25}\selectfont}
\renewcommand{\scriptsize}{\fontsize{24.88}{30}\selectfont}
\renewcommand{\footnotesize}{\fontsize{29.86}{37}\selectfont}
\renewcommand{\small}{\fontsize{35.83}{45}\selectfont}
\renewcommand{\normalsize}{\fontsize{34}{54}\selectfont}
\renewcommand{\large}{\fontsize{51.6}{64}\selectfont}
\renewcommand{\Large}{\fontsize{61.92}{77}\selectfont}
\renewcommand{\LARGE}{\fontsize{74.3}{93}\selectfont}
\renewcommand{\huge}{\fontsize{89.16}{112}\selectfont}
\renewcommand{\Huge}{\fontsize{107}{134}\selectfont}

\normalsize
\setlength\parindent{2em}
\setlength\parskip{0pt plus .1ex}
%\setlength\parindent{0pt}
%\setlength\parskip{2ex}
\setlength\floatsep{45pt plus 5pt minus 5pt}
\setlength\textfloatsep{86pt plus 9pt minus 18pt}
\setlength\intextsep{25pt plus 5pt minus 15pt}
\setlength\dblfloatsep{45pt plus 5pt minus 5pt}
\setlength\dbltextfloatsep{86pt plus 9pt minus 18pt}

\setlength\abovedisplayskip{32pt plus 3pt minus 3pt}
\setlength\abovedisplayshortskip{14pt plus 3pt minus 3pt}
\setlength\belowdisplayskip{\abovedisplayskip}
\setlength\belowdisplayshortskip{\abovedisplayskip}

% ]]]

% utilities: string [[[

\def\tud@string@new{%
  \@ifnextchar [{\tud@string@new@i}{\tud@string@new@ii[][]}}%]

\def\tud@string@new@i[#1]{%
  \@ifnextchar [{\tud@string@new@ii[#1]}{\tud@string@new@ii[#1][]}}%]

\def\tud@string@new@ii[#1][#2]#3{%
  \csgdef{tud@string@separator@#3}{#1}%
  \csgdef{tud@string@end@#3}{#2}}

\def\tud@string@append#1#2{%
  \def\tud@tmp{#2}%
  \ifcsdef{tud@string@data@#1}{%
    \csxdef{tud@string@data@#1}{\csexpandonce{tud@string@data@#1}\csexpandonce{tud@string@separator@#1}\expandonce\tud@tmp}}{%
    \csxdef{tud@string@data@#1}{\expandonce\tud@tmp}}}

\def\tud@string@use#1{%
  \csuse{tud@string@data@#1}{\csuse{tud@string@end@#1}}}

\long\def\tud@string@ifempty#1#2#3{%
  \ifcsdef{tud@string@data@#1}{#3}{#2}}

% ]]]

% fonts and sections [[[

\renewcommand{\familydefault}{\sfdefault}
\newcommand{\tudstylesection}{\normalfont\sffamily\large\bfseries\color{tudcyan}}

\setcounter{secnumdepth}{0}
\renewcommand\section{%
  \@startsection{section}{1}{0pt}%
   {-2ex plus -1ex minus -.2ex}%
   {1ex plus 1ex}%
   {\tudstylesection}%
}

% ]]]
% authors [[[

% \addauthornote{key}[symbol]{description}

\def\tud@authornote@getsymbol#1{%
  \ifcsdef{tud@authornote@symbol@#1}{%
    \textsuperscript{\csuse{tud@authornote@symbol@#1}}}{%
    \ClassWarning{tudelftposter}{unknown author note '#1'}%
    \textsuperscript{{\bfseries??}}}}

\def\addauthornote#1{\@ifnextchar[{\tud@authornote@addi{#1}}{\tud@authornote@addii{#1}}}%]

\def\tud@authornote@addi#1[#2]#3{%
  \csgdef{tud@authornote@symbol@#1}{#2}%
  \tud@authornote@addiii{#1}{#3}}%

\newcounter{tud@authornote@symbolcounter}
\setcounter{tud@authornote@symbolcounter}{0}

\def\tud@authornote@addii#1#2{%
  \stepcounter{tud@authornote@symbolcounter}%
  \newcounter{tud@authornote@symbol@#1@counter}%
  \setcounter{tud@authornote@symbol@#1@counter}{%
    \value{tud@authornote@symbolcounter}}%
  \csgdef{tud@authornote@symbol@#1}{%
    \fnsymbol{tud@authornote@symbol@#1@counter}}%
  \tud@authornote@addiii{#1}{#2}}%

\tud@string@new[,\quad]{authornotes}
\def\tud@authornote@addiii#1#2{%
  \tud@string@append{authornotes}{\mbox{\tud@authornote@getsymbol{#1}{#2}}}}

% \addauthor[authornote1,authornote2]{name}

\newbox\tud@authors@tempboxa
\newbox\tud@authors@tempboxb

\def\tud@authors@foo#1#2{%
  \setbox\tud@authors@tempboxa\hbox{#1}%
  \setbox\tud@authors@tempboxb\hbox{#2}%
  \ifdimgreater{\wd\tud@authors@tempboxa}{\wd\tud@authors@tempboxb}{\makebox[0pt][l]{#2}#1}{\makebox[0pt][l]{#1}#2}}

\tud@string@new[,\quad][\null]{authors}
\def\addauthor{\@ifnextchar [{\tud@authors@add}{\tud@authors@add[]}}%]
\def\tud@authors@add[#1]#2{%
  \tud@string@append{authors}{%
    \mbox{#2}%
    \tud@authors@foo{%
    \@for\tud@tmp:=#1\do{%
      \tud@authornote@getsymbol{\tud@tmp}}}}}

% ]]]
% header [[[

\newcommand{\tudstyleheadtitle}{\normalfont\sffamily\color{white}\huge\bfseries}
\newcommand{\tudstyleheadauthors}{\normalfont\sffamily\Large\frenchspacing}
\newcommand{\tudstyleheadauthornotes}{\normalfont\sffamily\fontsize{32}{45}\selectfont}

\newlength\safetymargin
\setlength\safetymargin{1cm}

\def\@maketitle{%
  \newpage%
  \null%
  \setbox\@tempboxa\vbox{%
    \vskip 2em%
    \begin{center}%
    \let \footnote \thanks
      {\tudstyleheadtitle \@title \par}%
      \vskip 1.5em%
      {\Large
        \lineskip .5em%
        \tud@string@ifempty{authors}{{%
          \tudstyleheadauthors%
          % old style authors
          \begin{tabular}[t]{c}%
            \@author
          \end{tabular}}%
        }{%
          % new style authors
          {\tudstyleheadauthors%
          \tud@string@use{authors}}%
          \par\vskip .5em%
          {\tudstyleheadauthornotes%
          \tud@string@use{authornotes}}%
        }%
      }%
    \end{center}%
    \par%
    \vskip\columnsep}%
  \tud@headergradient{\ht\@tempboxa+\dp\@tempboxa}%
  \unvbox\@tempboxa%
}

\newlength\tud@titleheaderheight
\def\tud@headergradient#1{%
  \global\deflength\tud@titleheaderheight{#1}%
  \begin{tikzpicture}[remember picture,overlay]
    \node at (current page.north west)
      {\begin{tikzpicture}[remember picture,overlay]
        \iftud@opt@experimentalheadergradient
          \fill[tudcyan,path fading=south] (-\safetymargin,\safetymargin) rectangle (\paperwidth+\safetymargin,-\tud@titleheaderheight);
        \else
          \draw[draw=none,top color=tudcyan,bottom color=tud@backgroundcolor] (-\safetymargin,\safetymargin) rectangle (\paperwidth+\safetymargin,-\tud@titleheaderheight);
        \fi
       \end{tikzpicture}
      };
  \end{tikzpicture}}

\newcommand{\tud@set@tikz@body}{%
  \newlength{\tud@body@t}\deflength{\tud@body@t}{\paperheight-\tud@titleheaderheight-\columnsep}%
  \newlength{\tud@body@b}\deflength{\tud@body@b}{\footerheight+\columnsep}%
  \newlength{\tud@body@l}\deflength{\tud@body@l}{\tud@hmargin}%
  \newlength{\tud@body@r}\deflength{\tud@body@r}{\paperwidth-\tud@hmargin}%
  \csdef{pgf@sh@ns@body}{rectangle}%
  \csdef{pgf@sh@np@body}{%
    \def\southwest{\pgfqpoint{\tud@body@l}{\tud@body@b}}%
    \def\northeast{\pgfqpoint{\tud@body@r}{\tud@body@t}}%
  }%
  \csdef{pgf@sh@nt@body}{{1}{0}{0}{1}{0pt}{0pt}}%
  \csdef{pgf@sh@pi@body}{pgfpageorigin}%
}

\AfterEndPreamble{%
  \maketitle%
  \tud@set@tikz@body%
  \begin{multicols}{\tud@opt@ncolumns}}
\AtEndDocument{%
  \end{multicols}}

% ]]]
% footer [[[

\newlength\footerheight
\ifx\tud@opt@footerheight\@empty%
  \deflength\footerheight{.1\paperheight}%
\else%
  \deflength\footerheight{\tud@opt@footerheight}%
\fi
\newlength\footerheightwithmargin
\deflength\footerheightwithmargin{\footerheight+\columnsep}
\geometry{vmargin={0cm,\footerheightwithmargin}}

\newlength\footerblacklinewidth
\deflength\footerblacklinewidth{1pt}
\newlength\footerwhiteliney
\deflength\footerwhiteliney{.115\footerheight}
\newlength\footerwhitelinewidth
\deflength\footerwhitelinewidth{.01\footerheight}
\newlength\footerblueyi
\deflength\footerblueyi{\footerwhiteliney-.5\footerwhitelinewidth}
\newlength\footerblueyii
\deflength\footerblueyii{\footerwhiteliney+.5\footerwhitelinewidth}
\newlength\footerblueyiii
\deflength\footerblueyiii{.4\footerheight}
\newlength\footerimagemargin
\deflength\footerimagemargin{.085\footerheight}
\newlength\footerimageheight
\deflength\footerimageheight{\footerheight-\footerblueyiii-2\footerimagemargin}

\newlength\footerimagey
\deflength\footerimagey{\footerblueyiii+\footerimagemargin}

\newcommand{\tudfooterfontsize}{\fontsize{0.1\footerheight}{0.125\footerheight}\selectfont}
\newcommand{\tudstylefooter}{\normalfont\sffamily\color{white}\tudfooterfontsize\bfseries}
\newlength\footertextheight
\settoheight\footertextheight{\tudstylefooter X}
\newlength\footerimagetexty
\deflength\footerimagetexty{.5\footerblueyii+.5\footerblueyiii-.5\footertextheight}

\tud@string@new{footer}

\def\ps@plain{%
  \let\@mkboth\@gobbletwo%
  \let\@oddhead\@empty%
  \def\@oddfoot{%
    \reset@font%
    \begin{tikzpicture}[remember picture,overlay]
      \node at (current page.south west)
        {\begin{tikzpicture}[remember picture, overlay]
          \fill[tudcyan] (-\safetymargin,-\safetymargin) rectangle (\paperwidth+\safetymargin,\footerblueyi);
          \fill[tudcyan] (-\safetymargin,\footerblueyii) rectangle (\paperwidth+\safetymargin,\footerblueyiii);
          \fill[black] (-\safetymargin,\footerheight) rectangle (\paperwidth+\safetymargin,\footerheight+\footerblacklinewidth);
          \tud@string@use{footer}
         \end{tikzpicture}
        };
     \end{tikzpicture}%
     \hfil}%
  \let\@evenhead\@empty%
  \let\@evenfoot\@oddfoot}

\def\tud@footer@getposition#1{\csuse{tud@footer@position@#1}}
\def\tud@footer@position@c{above}
\def\tud@footer@position@l{above right}
\def\tud@footer@position@r{above left}

\def\tud@footer@addtoimagebar#1#2#3{%
  \tud@string@append{footer}{%
    \node[inner sep=0pt,\tud@footer@getposition{#1}] at (\tud@xpos@resolve{#2},\footerimagey) {%
      {#3}};}}

\def\tud@footer@addtotextbar#1#2#3{%
  \tud@string@append{footer}{%
    \node[inner sep=0pt,\tud@footer@getposition{#1},baseline=0cm] at (\tud@xpos@resolve{#2},\footerimagetexty) {%
      \raisebox{0pt}[\height][0pt]{{\tudstylefooter #3}}};}}

\pagestyle{plain}

\def\addfootimage(#1:#2){%
  \@ifnextchar [{\tud@footer@addimage{#1}{#2}}{\tud@footer@addimage{#1}{#2}[]}}%]

\def\tud@footer@addimage#1#2[#3]#4{%
  \tud@footer@addtotextbar{#1}{#2}{#3}%
  \tud@footer@addtoimagebar{#1}{#2}{\includegraphics[height=\footerimageheight]{#4}}}

\def\addfootobject{%
  \@ifstar{\tud@footer@addrawobject}{\tud@footer@addobject}}

\def\tud@footer@addrawobject(#1:#2){%
  \@ifnextchar [{\tud@footer@addrawobjecti{#1}{#2}}{\tud@footer@addrawobjecti{#1}{#2}[]}}%]

\def\tud@footer@addrawobjecti#1#2[#3]#4{%
  \tud@footer@addtotextbar{#1}{#2}{#3}%
  \tud@footer@addtoimagebar{#1}{#2}{#4}}

\def\tud@footer@addobject(#1:#2){%
  \@ifnextchar [{\tud@footer@addobjecti{#1}{#2}}{\tud@footer@addobjecti{#1}{#2}[]}}%]

\def\tud@footer@addobjecti#1#2[#3]#4{%
  \tud@footer@addtotextbar{#1}{#2}{#3}%
  \tud@footer@addtoimagebar{#1}{#2}{\resizebox{!}{\footerimageheight}{#4}}}

\def\addfoottext(#1:#2)#3{%
  \tud@footer@addtotextbar{#1}{#2}{#3}}

\def\addfootqrcode(#1:#2){%
  \@ifnextchar [{\tud@footer@addqrcode{#1}{#2}}{\tud@footer@addqrcode{#1}{#2}[]}}%]

\def\tud@footer@addqrcode#1#2[#3]#4{%
  \tud@footer@addtotextbar{#1}{#2}{#3}%
  \tud@footer@addtoimagebar{#1}{#2}{\qrcode[hyperlink,height=\footerimageheight]{#4}}}

% position aliases

\def\tud@xpos@resolve#1{%
  \ifcsdef{tud@xpos@@\detokenize{#1}}{\csuse{tud@xpos@@#1}}{#1}}

\def\tud@def@xpos#1#2{%
  \expandafter\newlength\csname tud@xpos@@#1\endcsname%
  \expandafter\deflength\csname tud@xpos@@#1\endcsname{#2}}%

\tud@def@xpos{page.center}{.5\paperwidth}%
\tud@def@xpos{page.left}{0pt}%
\tud@def@xpos{page.right}{\paperwidth}%

\tud@def@xpos{body.center}{.5\paperwidth}%
\tud@def@xpos{body.left}{\tud@hmargin}%
\tud@def@xpos{body.right}{\paperwidth-\columnsep}%

\newlength{\tud@columnwidth}
\deflength{\tud@columnwidth}{(\paperwidth-2\tud@hmargin+\columnsep)/\tud@opt@ncolumns-\columnsep}
\newcounter{tud@xpos@item}
\setcounter{tud@xpos@item}{0}
\@whilenum{\value{tud@xpos@item}<\tud@opt@ncolumns}\do{%
  \tud@def@xpos{column\thetud@xpos@item.center}{\tud@hmargin+\value{tud@xpos@item}\tud@columnwidth+\value{tud@xpos@item}\columnsep+0.5\tud@columnwidth}%
  \tud@def@xpos{column\thetud@xpos@item.left}{\tud@hmargin+\value{tud@xpos@item}\tud@columnwidth+\value{tud@xpos@item}\columnsep}%
  \tud@def@xpos{column\thetud@xpos@item.right}{\tud@hmargin+\value{tud@xpos@item}\tud@columnwidth+\value{tud@xpos@item}\columnsep+\tud@columnwidth}%
  \stepcounter{tud@xpos@item}%
}

\setcounter{tud@xpos@item}{0}
\tud@def@xpos{left column.center}{\tud@hmargin+\value{tud@xpos@item}\tud@columnwidth+\value{tud@xpos@item}\columnsep+0.5\tud@columnwidth}%
\tud@def@xpos{left column.left}{\tud@hmargin+\value{tud@xpos@item}\tud@columnwidth+\value{tud@xpos@item}\columnsep}%
\tud@def@xpos{left column.right}{\tud@hmargin+\value{tud@xpos@item}\tud@columnwidth+\value{tud@xpos@item}\columnsep+\tud@columnwidth}%
\setcounter{tud@xpos@item}{\tud@opt@ncolumns}
\addtocounter{tud@xpos@item}{-1}%
\tud@def@xpos{right column.center}{\tud@hmargin+\value{tud@xpos@item}\tud@columnwidth+\value{tud@xpos@item}\columnsep+0.5\tud@columnwidth}%
\tud@def@xpos{right column.left}{\tud@hmargin+\value{tud@xpos@item}\tud@columnwidth+\value{tud@xpos@item}\columnsep}%
\tud@def@xpos{right column.right}{\tud@hmargin+\value{tud@xpos@item}\tud@columnwidth+\value{tud@xpos@item}\columnsep+\tud@columnwidth}%

% ]]]
% floats [[[

\renewenvironment{table}[1][1]%
{%
  \setlength{\parindent}{0pt}%
  \vspace{\baselineskip}%
  \def\@captype{table}
}{%
  \vspace{\baselineskip}%
}

\renewenvironment{figure}[1][1]%
{%
  \setlength{\parindent}{0pt}%
  \vspace{\intextsep}%
  \def\@captype{figure}
}{%
  \vspace{\intextsep}%
}

\captionsetup{font={small,sl}}

% ]]]
% list environments [[[

\setlength\leftmargini  {2em}
\leftmargin  \leftmargini
\setlength\leftmarginii  {2.2em}
\setlength\leftmarginiii {1.87em}
\setlength\leftmarginiv  {1.7em}
\setlength\leftmarginv  {.5em}
\setlength\leftmarginvi {.5em}
\setlength  \labelsep  {.5em}
\setlength  \labelwidth{\leftmargini}
\addtolength\labelwidth{-\labelsep}
\@beginparpenalty -\@lowpenalty
\@endparpenalty   -\@lowpenalty
\@itempenalty     -\@lowpenalty
\renewcommand\labelitemi{{\fontfamily{lmr}\selectfont\textbullet}}
\renewcommand\labelitemii{\normalfont\bfseries \textendash}
\renewcommand\labelitemiii{\textasteriskcentered}
\renewcommand\labelitemiv{\textperiodcentered}

% ]]]
% block [[[

\newlength\tud@block@inset%
\newlength\tud@block@vmargin%
\newlength\tud@block@hmargin%
\newlength\tud@block@textwidth%

\newcommand{\experimentalblockleft}[1]{%
  \begin{figure}
    \setlength\tud@block@inset{\oddsidemargin}%
    \addtolength\tud@block@inset{1in}%
    \addtolength\tud@block@inset{\safetymargin}%
    \setlength\tud@block@vmargin{.5\columnsep}%
    \setlength\tud@block@hmargin{\columnsep}%
    \setlength\tud@block@textwidth{\columnwidth}%
    \addtolength\tud@block@textwidth{-\tud@block@hmargin}%
    \hspace{-\tud@block@inset}%
    \makebox[0pt][l]{%
      \colorbox{black}{%
        \vbox{%
          \vbox to\tud@block@vmargin{\vfill}%
          \hbox{%
            \hspace{\tud@block@inset}\parbox{\tud@block@textwidth}{%
              \color{white}%
              \bfseries%
              #1%
            }\hspace{\tud@block@hmargin}%
          }%
          \vbox to\tud@block@vmargin{\vfill}%
        }%
      }%
    }%
  \end{figure}%
}

\newcommand{\experimentalblockright}[1]{%
  \begin{figure}%
    \setlength\tud@block@inset{\evensidemargin}%
    \addtolength\tud@block@inset{1in}%
    \addtolength\tud@block@inset{\safetymargin}%
    \setlength\tud@block@vmargin{.5\columnsep}%
    \setlength\tud@block@hmargin{\columnsep}%
    \setlength\tud@block@textwidth{\columnwidth}%
    \addtolength\tud@block@textwidth{-\tud@block@hmargin}%
%   \hspace{-\tud@block@inset}%
    \makebox[0pt][l]{%
      \colorbox{black}{%
        \vbox{%
          \vbox to\tud@block@vmargin{\vfill}%
          \hbox{%
            \hspace{\tud@block@hmargin}\parbox{\tud@block@textwidth}{%
              \color{white}%
              \bfseries%
              #1%
            }\hspace{\tud@block@inset}%
          }%
          \vbox to\tud@block@vmargin{\vfill}%
        }%
      }%
    }%
  \end{figure}%
}

% ]]]

% vim: ts=2:sts=2:sw=2:et:fdm=marker:fmr=[[[,]]]
