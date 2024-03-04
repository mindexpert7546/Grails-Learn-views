package school

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    
        get "/countStudents/$subject(.$format)?"(controller:"student", action:"countStudents")

        get "/allMathsStd/$subject(.$format)?"(controller:"student", action:"allMathsStd")

        get "/studentNameOnly/$name(.$format)?"(controller:"student", action:"studentNameOnly")

        get "/StudentCount" (controller:"student", action:"studentCount")

        get "/teacherName/$subject(.$format)?"(controller:"student", action:"teacherName")

       
        get "/aStudent/$name(.$format)?"(controller:"student", action:" aStudent")
    }
}
