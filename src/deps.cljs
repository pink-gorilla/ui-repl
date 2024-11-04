{:npm-deps
 {; shadow cljs creates package.json 
  ; based on this dependencies 

  ;; this are the npm deps of tick:
  ;; {:npm-deps {"@js-joda/timezone" "2.5.0"
  ;;          "@js-joda/locale_en-us" "3.1.1"}}
  ;; tick does not bring js-joda/timezone, so this is the reason why zoned-date-time dont work in browser.

  ;"@js-joda/core" "3.2.0"
  ;"@js-joda/locale_en-us" "3.1.1" ; Locale (just en-US) is an extra 45k
  "@js-joda/timezone" "^2.5.0" ;Timezone is an extra 26k
 ;
  }}

