(define (perevod x)
  (let ((y (char->integer x)))
    (if (> y 57)
        (if (> y 90)
            (- y 87)
            (- y 55))
        (- y 48))))

(define (test s b)
  (if (null? (string->list s))
      (null? (string->list s))
      (if (>= (perevod (car (string->list s))) b)
          (not (>= (perevod (car (string->list s))) b))
          (test (list->string (cdr (string->list s))) b))))

(define (summa s b i)
  (if (equal? i 0)
      (perevod (car (string->list s)))
      (+ (* (perevod (car (string->list s))) (expt b i)) (summa (list->string (cdr (string->list s))) b (- i 1)))))
                

(define (certain->decimal s b)
  (if (test s b)
      (summa s b (- (length (string->list s)) 1))        
      'number-conversion-error))

(define (correct-number? s b)
  (test s b))

(define (perevodobr x)
  (if (< x 10)
      (car (string->list (number->string x)))
      (integer->char (+ x 87))))

(define spis (list))
(define (decimal->certain d b)
  (let ((a (quotient d b)))
    (set!  spis (append (list (perevodobr (remainder d b))) spis))
    (if (equal? a 0)
        (list->string spis)
        (decimal->certain a b))))